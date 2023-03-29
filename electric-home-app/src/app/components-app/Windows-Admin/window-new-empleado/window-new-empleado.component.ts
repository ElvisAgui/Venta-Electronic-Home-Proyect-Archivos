import { Usuario } from './../../../../class-models/usuario';
import { Cargo } from './../../../../class-models/cargo';
import { AdminService } from './../../../services/admin.service';
import { InventarioService } from './../../../services/inventario.service';
import { Component, OnInit } from '@angular/core';
import { Sucursal } from 'src/class-models/sucursal';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-new-empleado',
  templateUrl: './window-new-empleado.component.html',
  styleUrls: ['./window-new-empleado.component.css']
})
export class WindowNewEmpleadoComponent implements OnInit {

  sucursales: Sucursal[] = [];
  cargos:Cargo[]=[]
  tipoCargo:number=0
  codigoSucursal:number = 0
  cui:String=''
  nombre:String=''
  apellido:String=''
  passworde:String=''
  salario:number = 0
  idbodega: number= 10
  constructor(private inventServi: InventarioService,
    private adimnServi:AdminService) { }

  ngOnInit(): void {
    this.inventServi.getSucursales().subscribe(
      (created: Sucursal[]) => {
        if (created != null) {
          this.sucursales = created;
        }
      },
      (error: any) => {}
    );
    this.adimnServi.getCargos().subscribe(
      (created: Cargo[]) => {
        if (created != null) {
          this.cargos = created;
        }
      },
      (error: any) => {}
    )
  }


  public registrar(){
    if (this.verificacionCampos()) {
      const usuario:Usuario = new Usuario()
      usuario.apellido = this.apellido
      usuario.cui = this.cui
      usuario.nombre = this.nombre
      usuario.passworde = this.passworde
      usuario.salario = this.salario
      usuario.codigoSucursal = this.calculoSucursal(this.codigoSucursal)
      usuario.tipoCargo = this.calculoTipoCargo(this.tipoCargo)
      if (this.tipoCargo == 2) {
        this.codigoSucursal = 10
      }
      this.adimnServi.saveEmpleado(usuario).subscribe(
        (created: Usuario) => {
          if (created != null) {
            Swal.fire(
              'Proceso completado con exito',
              'el empleado fue creado con exito',
              'success'
            );
          }else{
            Swal.fire(
              'Upss!!',
              'Error en el servidor al guardar el empleado',
              'error'
            );
          }
        },
        (error: any) => {}
      )

    }
  }

  private calculoSucursal(index:number):number{
    if (this.codigoSucursal == 10) {
      return 10;
    } 
    return this.sucursales[index].codigoId
  }

  private calculoTipoCargo(index:number):number{
    return this.cargos[index].codigoId
  }

  private verificacionCampos():boolean{
    if (this.cui == '' || this.nombre =='' || this.apellido == '' || this.passworde == '' || this.salario<=0 || this.apellido == '') {
      Swal.fire(
        'Upss!!',
        'Ingresa correctamente los datos del nuevo usuario',
        'error'
      );return false
    }
    return true
  }

}
