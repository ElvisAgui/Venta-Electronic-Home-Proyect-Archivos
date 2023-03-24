import { VentaService } from './../../../services/venta.service';
import { Router } from '@angular/router';
import { Sucursal } from 'src/class-models/sucursal';
import { CreateSecionService } from './../../../services/create-secion.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/class-models/usuario';
import { WindowRootComponent } from '../../window-root/window-root.component';
import { Cliente } from 'src/class-models/cliente';
import Swal from 'sweetalert2';
import { Producto } from 'src/class-models/producto';

@Component({
  selector: 'app-navbar-ventas',
  templateUrl: './navbar-ventas.component.html',
  styleUrls: ['./navbar-ventas.component.css']
})
export class NavbarVentasComponent implements OnInit {

  usuario:Usuario;
  sucursal:Sucursal
  constructor(private sesion:CreateSecionService,
    private route:Router,
    private serviceVenta:VentaService) {
    this.usuario= sesion.usuario
    this.sucursal=this.sesion.sucursalContratado
   }

  ngOnInit(): void {
  }

  public dirigirPerfil(){
    this.route.navigate(['Area-Ventas/perfil'])
  }

  public dirigirVentas(){
    this.route.navigate(['Area-Ventas/ventas'])
  }

  public dirigirAreaClientes(){
    this.serviceVenta.getClientes().subscribe(
      (created:Cliente[])=> {
        if (created !== null && created !== undefined ) {
          this.sesion.clientes = created
          this.route.navigate(['Area-Ventas/clientes'])
        }else{
          Swal.fire(
            'ALGO SALIO MAL',
            'El servidor no pudo responde al obtener el listado de clientes',
            'question'
          );
          this.route.navigate(['Area-Ventas/clientes'])
        }
      },
      (erro:any)=> {

      }
    );
  }

  public dirigirProductos(){
    this.serviceVenta.getProductos(this.sesion.sucursalContratado.codigoId).subscribe(
      (created:Producto[])=> {
        if (created !== null && created !== undefined ) {
          this.sesion.porductos = created
          this.route.navigate(['Area-Ventas/productos'])
        }else{
          Swal.fire(
            'ALGO SALIO MAL',
            'El servidor no pudo responde al obtener el listado de Productos',
            'question'
          );
          this.route.navigate(['Area-Ventas/productos'])
        }
      },
      (erro:any)=> {

      }
    );
  }

}
