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
  constructor(private formBuilder: FormBuilder, private serviceLogin: LoginUsersService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      usuario: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  public login(){
   this.serviceLogin.getEmpleados().subscribe(
    (created: Usuario[]) => {
      this.loginForm.reset({
        usuario: null,
        password: null,
      });
      this.usuarios=created
      console.log(this.usuarios)
    },
    (erro: any) => {
      //pag errro
      console.log('peticion xd')
    }
   );
    
  }

}
