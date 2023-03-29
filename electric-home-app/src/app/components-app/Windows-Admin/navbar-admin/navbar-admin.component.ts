import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { Usuario } from 'src/class-models/usuario';

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css'],
})
export class NavbarAdminComponent implements OnInit {
  usuario: Usuario;
  constructor(private sesion: CreateSecionService, private route: Router) {
    this.usuario = sesion.usuario;
  }

  ngOnInit(): void {}

  public dirigeNewEmpleado() {
    this.route.navigate(['Area-Administracion/new-empleado']);
  }

  public dirigePerfil() {
    this.route.navigate(['Area-Administracion/perfil']);
  }

  public goReport(tipoRpor: number) {
    this.sesion.tipoReport = tipoRpor;
    this.route.navigate(['Area-Administracion/reportes']);
  }
}
