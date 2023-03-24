import { CreateSecionService } from './../../services/create-secion.service';
import { LoginUsersService } from './../../services/login-users.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterModule, Routes, CanActivate, Router } from '@angular/router';

import { Usuario } from 'src/class-models/usuario';
import { Sucursal } from 'src/class-models/sucursal';
@Component({
  selector: 'app-window-root',
  templateUrl: './window-root.component.html',
  styleUrls: ['./window-root.component.css'],
})
export class WindowRootComponent implements OnInit {
  loginForm!: FormGroup;
  usuarios!: Usuario[];
  usuario!: Usuario;
  sucursal!: Sucursal;
  static autenticado = false;
  constructor(
    private formBuilder: FormBuilder,
    private serviceLogin: LoginUsersService,
    private router: Router,
    private secion: CreateSecionService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      cui: [null, Validators.required],
      passworde: [null, Validators.required],
    });
  }

  public login() {
    this.serviceLogin.getEmpleados(this.loginForm.value).subscribe(
      (created: Usuario) => {
        this.loginForm.reset({
          cui: null,
          passworde: null,
        });
        this.usuario = created;
        this.getSucursal();
      },
      (erro: any) => {
        //pag errro
        console.log('peticion xd');
      }
    );
  }

  public getSucursal() {
    this.serviceLogin.getSucursalContradado(this.usuario).subscribe(
      (sucu: Sucursal) => {
        this.secion.sucursalContratado = sucu;
        this.digeAreaTrabajo(this.usuario);
      },
      (erro: any) => {
        //error al obtener la sucursal
      }
    );
  }

  public digeAreaTrabajo(usuarioSec: Usuario) {
    if (usuarioSec != null && usuarioSec != undefined) {
      switch (usuarioSec.tipoCargo) {
        case 1:
          WindowRootComponent.autenticado = true;
          this.secion.usuario = usuarioSec;
          this.router.navigate(['Area-Ventas/perfil']);
          break;
        case 2:
          this.router.navigate(['']);
          break;
        default:
          break;
      }
    } else {
      console.log('usuario o passwor invalido gay');
    }
  }
}
