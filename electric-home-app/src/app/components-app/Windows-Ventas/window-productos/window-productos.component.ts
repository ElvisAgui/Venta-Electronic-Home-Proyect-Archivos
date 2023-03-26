import { InventarioService } from './../../../services/inventario.service';
import { Usuario } from 'src/class-models/usuario';
import { Producto } from 'src/class-models/producto';
import { CreateSecionService } from './../../../services/create-secion.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-productos',
  templateUrl: './window-productos.component.html',
  styleUrls: ['./window-productos.component.css'],
})
export class WindowProductosComponent implements OnInit {
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

  public mostrarNavVenta(): boolean {
    return this.usuario.tipoCargo == 1;
  }

  public aumentarEnUno(index: number) {
    this.inventService
      .aumentarEnuno(this.productos[index], this.sesion.sucursalContratado)
      .subscribe(
        (created: boolean) => {
          if (created) {
            this.productos[index].cantidad = this.productos[index].cantidad+1;
          }else{
            Swal.fire(
              'Upss!!',
              'Ubo un error en El aumento, Escribale al servicio Tecnico XD',
              'error'
            );
          }
        },
        (error: any) => {}
      );
  }
}
