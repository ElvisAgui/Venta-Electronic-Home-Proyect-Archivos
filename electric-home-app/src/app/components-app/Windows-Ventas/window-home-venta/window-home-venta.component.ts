import { Sucursal } from './../../../../class-models/sucursal';
import { LoginUsersService } from './../../../services/login-users.service';
import { CreateSecionService } from './../../../services/create-secion.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/class-models/usuario';

@Component({
  selector: 'app-window-home-venta',
  templateUrl: './window-home-venta.component.html',
  styleUrls: ['./window-home-venta.component.css'],
})
export class WindowHomeVentaComponent implements OnInit {
  usuario!: Usuario;
  sucursal!: Sucursal;

  constructor(
    private secionService: CreateSecionService,
    private loginSerive: LoginUsersService
  ) {
    
  }

  ngOnInit(): void {
    this.sucursal=this.secionService.sucursalContratado
    this.usuario = this.secionService.usuario;
  }

  public mostrarNavVenta():boolean{
    return this.usuario.tipoCargo ==1
  }
}
