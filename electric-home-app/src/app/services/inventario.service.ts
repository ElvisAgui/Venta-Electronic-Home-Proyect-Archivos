import { SolucionPedido } from './../../class-models/solucion-pedido';
import { Pedido } from './../../class-models/pedido';
import { Bodega } from './../../class-models/bodega';
import { Sucursal } from 'src/class-models/sucursal';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from 'src/class-models/producto';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  readonly API_URL = 'http://localhost:8080/Electronic-Home/inventario/';
  constructor(private httpClient: HttpClient) { }


  public getSucursales():Observable<Sucursal[]> {
    return this.httpClient.get<Sucursal[]>(this.API_URL+'getSucursales')
  }

  public getBodegas():Observable<Bodega[]> {
    return this.httpClient.get<Bodega[]>(this.API_URL+'getBodega')
  }

  public savePedido(pedido:Pedido):Observable<boolean>{
    return this.httpClient.post<boolean>(this.API_URL+'savePedido', pedido)
  }

  public getProducto(codigoSucu:number, codigoPro:String): Observable<Producto>{
    return this.httpClient.get<Producto>(this.API_URL+'getProducto?sucursal='+codigoSucu+'&producto='+codigoPro);
  }
  
  public getProductoBodega(codigoSucu:number, codigoPro:String): Observable<Producto>{
    return this.httpClient.get<Producto>(this.API_URL+'getProductoBodega?sucursal='+codigoSucu+'&producto='+codigoPro);
  }

  public getPedidos(estado:String, codigoSucur:number): Observable<SolucionPedido[]>{
    return this.httpClient.get<SolucionPedido[]>(this.API_URL+'getPedidos?estado='+estado+'&codigo='+codigoSucur);
  }

  public solucioPedido(solPedido:SolucionPedido, sucursalActual:Sucursal):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'solucionPedido?SucurDescuento='+sucursalActual.codigoId, solPedido)
  }

  public rechazarPedido(solPedido:SolucionPedido):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'rechazarPedido',solPedido) 
  }

  public aumentarEnuno(producto:Producto, sucursalActual:Sucursal):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'aumentarCantidad?codigoSucursal='+sucursalActual.codigoId, producto)
  }
  



}

