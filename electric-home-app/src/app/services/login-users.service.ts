import { Usuario } from './../../class-models/usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginUsersService {

  readonly API_URL = "http://localhost:8080/Electronic-Home/";

  constructor(private httpClient: HttpClient) { }

  public getEmpleados():Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(this.API_URL+'empleados');
  }

  public crearUsuario(usuarioN: Usuario): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL + "ControladorUsuario", usuarioN);
  }
}
