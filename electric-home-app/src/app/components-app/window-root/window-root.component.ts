import { LoginUsersService } from './../../services/login-users.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/class-models/usuario';
@Component({
  selector: 'app-window-root',
  templateUrl: './window-root.component.html',
  styleUrls: ['./window-root.component.css']
})
export class WindowRootComponent implements OnInit {
  
  loginForm!: FormGroup;
  usuarios!: Usuario[];
  usuario!:Usuario;
  constructor(private formBuilder: FormBuilder, private serviceLogin: LoginUsersService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      cui: [null, Validators.required],
      passworde: [null, Validators.required],
    });
  }

  public login(){
   this.serviceLogin.getEmpleados(this.loginForm.value).subscribe(
    (created: Usuario) => {
      this.loginForm.reset({
        cui: null,
        passworde: null,
      });
      this.usuario=created
      this.digeAreaTrabajo(this.usuario);
    },
    (erro: any) => {
      //pag errro
      console.log('peticion xd')
    }
   );
  }

  public digeAreaTrabajo(usuario:Usuario){
    if (usuario != null && usuario != undefined) {
      console.log(usuario)
    }else{
      console.log("usuario o passwor invalido gay")
    }
  }

}
