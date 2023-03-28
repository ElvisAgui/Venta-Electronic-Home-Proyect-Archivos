import { BodegaService } from './../../../services/bodega.service';
import { VentaService } from 'src/app/services/venta.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { Cliente } from 'src/class-models/cliente';
import { Producto } from 'src/class-models/producto';
import { Sucursal } from 'src/class-models/sucursal';
import { Usuario } from 'src/class-models/usuario';
import Swal from 'sweetalert2';
import { Bodega } from 'src/class-models/bodega';

@Component({
  selector: 'app-navbar-bodega',
  templateUrl: './navbar-bodega.component.html',
  styleUrls: ['./navbar-bodega.component.css']
})
export class NavbarBodegaComponent implements OnInit {

  usuario:Usuario;
  sucursal:Bodega
  constructor(private sesion:CreateSecionService,
    private route:Router,
    private serviBodega:BodegaService) {
    this.usuario= sesion.usuario
    this.sucursal=this.sesion.bodegaContratado
   }

  ngOnInit(): void {
  }

  public dirigirPerfil(){
    this.route.navigate(['Area-Bodega/perfil'])
  }

  public dirigirFormulario(){
    this.route.navigate(['Area-Bodega/newProducto'])
  }

  public dirigirSolicitudes(){
    this.route.navigate(['Area-Bodega/solicitudes'])
  }

  public dirigirProductos(){
    this.serviBodega.getProductos(this.sesion.bodegaContratado.codigoId).subscribe(
      (created:Producto[])=> {
        if (created !== null && created !== undefined ) {
          this.sesion.porductos = created
          this.route.navigate(['Area-Bodega/productos'])
        }else{
          Swal.fire(
            'ALGO SALIO MAL',
            'El servidor no pudo responde al obtener el listado de Productos',
            'question'
          );
          this.route.navigate(['Area-Bodega/productos'])
        }
      },
      (erro:any)=> {

      }
    );
  }


}
