import { Bodega } from './../../../../class-models/bodega';
import { Component, OnInit } from '@angular/core';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { LoginUsersService } from 'src/app/services/login-users.service';
import { Sucursal } from 'src/class-models/sucursal';
import { Usuario } from 'src/class-models/usuario';

@Component({
  selector: 'app-window-perfil',
  templateUrl: './window-perfil.component.html',
  styleUrls: ['./window-perfil.component.css']
})
export class WindowPerfilComponent implements OnInit {

  usuario!: Usuario;
  sucursal!: Bodega;

  constructor(
    private secionService: CreateSecionService,
    private loginSerive: LoginUsersService
  ) {
    
  }

  ngOnInit(): void {
    this.sucursal=this.secionService.bodegaContratado
    this.usuario = this.secionService.usuario;
  }

}
