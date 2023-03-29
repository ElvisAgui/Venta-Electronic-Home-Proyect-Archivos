import { SucursalReport } from './../../class-models/sucursal-report';
import { ProductoReport } from './../../class-models/producto-report';
import { Producto } from 'src/class-models/producto';
import { EmpleadoReport } from './../../class-models/empleado-report';
import { ClienteReport } from './../../class-models/cliente-report';
import { Usuario } from './../../class-models/usuario';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cargo } from 'src/class-models/cargo';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  
  readonly API_URL = 'http://localhost:8080/Electronic-Home/administracion/';
  constructor(private httpClient: HttpClient) { }

  public getCargos():Observable<Cargo[]> {
    return this.httpClient.get<Cargo[]>(this.API_URL+'getCargos')
  }

  public saveEmpleado(usuario:Usuario):Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_URL+'saveEmpleado', usuario)
  }

  public getReporteClientes():Observable<ClienteReport[]>{
    return this.httpClient.get<ClienteReport[]>(this.API_URL+'getClientesReport')
  }

  public getReportEmpleadoMasVenta():Observable<EmpleadoReport[]>{
    return this.httpClient.get<EmpleadoReport[]>(this.API_URL+'getEmpleadoReportMasVenta')
  }

  public getReportEmpleadoMasIngresos():Observable<EmpleadoReport[]>{
    return this.httpClient.get<EmpleadoReport[]>(this.API_URL+'getEmpleadoReportMasIngresos')
  }

  public getProductoMasVendido():Observable<ProductoReport[]>{
    return this.httpClient.get<ProductoReport[]>(this.API_URL+'getProductoMasVendido')
  }

  public getProductoMasIngreso():Observable<ProductoReport[]>{
    return this.httpClient.get<ProductoReport[]>(this.API_URL+'getProductoMasIngreso')
  }

  public getProductoMasVendidoSucursal(codigo:number):Observable<ProductoReport[]>{
    return this.httpClient.get<ProductoReport[]>(this.API_URL+'getProductoMasVendidoSucural?sucursal='+codigo)
  }

  public getProductoMasIngresosSucursal(codigo:number):Observable<ProductoReport[]>{
    return this.httpClient.get<ProductoReport[]>(this.API_URL+'getProductoMasIngresoSucursal?sucursal='+codigo)
  }

  public getSucursalMasVentas():Observable<SucursalReport[]>{
    return this.httpClient.get<SucursalReport[]>(this.API_URL+'getSucursalMasVentas')
  }

  public getSucursalMasIngresos():Observable<SucursalReport[]>{
    return this.httpClient.get<SucursalReport[]>(this.API_URL+'getSucursalMasIngresos')
  }

}
