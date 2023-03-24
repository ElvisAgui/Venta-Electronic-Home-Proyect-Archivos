import { Sucursal } from './../../class-models/sucursal';
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

  public getEmpleados(emplealdo:Usuario):Observable<Usuario>{
    return this.httpClient.get<Usuario>(this.API_URL+'empleadoSecion?cui='+emplealdo.cui+'&password='+emplealdo.passworde);
  }

  public getSucursalContradado(empleado:Usuario):Observable<Sucursal>{
    return this.httpClient.get<Sucursal>(this.API_URL+'empleadoSucursal?sucursal='+empleado.codigoSucursal);
  }

  public crearUsuario(usuarioN: Usuario): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL + "ControladorUsuario", usuarioN);
  }
}
