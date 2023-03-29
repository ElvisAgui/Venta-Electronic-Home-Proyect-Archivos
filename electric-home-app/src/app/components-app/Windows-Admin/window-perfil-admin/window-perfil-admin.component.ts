import { Component, OnInit } from '@angular/core';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { LoginUsersService } from 'src/app/services/login-users.service';
import { Bodega } from 'src/class-models/bodega';
import { Usuario } from 'src/class-models/usuario';

@Component({
  selector: 'app-window-perfil-admin',
  templateUrl: './window-perfil-admin.component.html',
  styleUrls: ['./window-perfil-admin.component.css']
})
export class WindowPerfilAdminComponent implements OnInit {

  usuario!: Usuario;


  constructor(
    private secionService: CreateSecionService,
    private loginSerive: LoginUsersService
  ) {
    
  }

  ngOnInit(): void {
    this.usuario = this.secionService.usuario;
  }

}
