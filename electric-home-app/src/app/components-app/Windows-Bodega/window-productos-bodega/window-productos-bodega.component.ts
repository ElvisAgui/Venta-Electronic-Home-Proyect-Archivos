import { Component, OnInit } from '@angular/core';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { InventarioService } from 'src/app/services/inventario.service';
import { Producto } from 'src/class-models/producto';
import { Usuario } from 'src/class-models/usuario';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-productos-bodega',
  templateUrl: './window-productos-bodega.component.html',
  styleUrls: ['./window-productos-bodega.component.css']
})
export class WindowProductosBodegaComponent implements OnInit {

  productos: Producto[] = [];
  usuario!: Usuario;
  constructor(
    private sesion: CreateSecionService,
    private inventService: InventarioService
  ) {
    this.productos = this.sesion.porductos;
    this.usuario = this.sesion.usuario;
  }

  ngOnInit(): void {}

  public modificarPro(index:number){
    this.sesion.ismodificacion = true
    this.sesion.productoModificacion = this.productos[index]
    Swal.fire(
      'Modificar Producto',
      'Dirigite al Formulario de producto',
      'question'
    );
  }

}
