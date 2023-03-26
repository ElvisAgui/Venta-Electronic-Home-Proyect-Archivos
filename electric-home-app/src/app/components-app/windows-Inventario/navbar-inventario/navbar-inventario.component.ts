import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { VentaService } from 'src/app/services/venta.service';
import { Producto } from 'src/class-models/producto';
import { Sucursal } from 'src/class-models/sucursal';
import { Usuario } from 'src/class-models/usuario';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-navbar-inventario',
  templateUrl: './navbar-inventario.component.html',
  styleUrls: ['./navbar-inventario.component.css']
})
export class NavbarInventarioComponent implements OnInit {

  usuario:Usuario;
  sucursal:Sucursal
  constructor(private sesion:CreateSecionService,
    private route:Router,
    private serviceVenta:VentaService) {
    this.usuario= sesion.usuario
    this.sucursal=this.sesion.sucursalContratado
   }

   public dirigirPerfil(){
    this.route.navigate(['Area-Inventario/perfil'])
  }

  public digirAreaPedidos(){
    this.route.navigate(['Area-Inventario/pedidos'])
  }

  public dirigirProductos(){
    this.serviceVenta.getProductos(this.sesion.sucursalContratado.codigoId).subscribe(
      (created:Producto[])=> {
        if (created !== null && created !== undefined ) {
          this.sesion.porductos = created
          this.route.navigate(['Area-Inventario/productos'])
        }else{
          Swal.fire(
            'ALGO SALIO MAL',
            'El servidor no pudo responde al obtener el listado de Productos',
            'question'
          );
          this.route.navigate(['Area-Inventario/productos'])
        }
      },
      (erro:any)=> {

      }
    );
  }

  public dirigirNewProd(){
    this.route.navigate(['Area-Inventario/newProducto'])
  }


  ngOnInit(): void {
  }

}
