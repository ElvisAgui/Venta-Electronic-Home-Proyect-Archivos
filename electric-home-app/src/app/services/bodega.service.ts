import { Marca } from './../../class-models/marca';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from 'src/class-models/producto';
import { SolucionPedido } from 'src/class-models/solucion-pedido';
import { Sucursal } from 'src/class-models/sucursal';

@Injectable({
  providedIn: 'root'
})
export class BodegaService {

  readonly API_URL = 'http://localhost:8080/Electronic-Home/bodega/';
  constructor(private httpClient: HttpClient) {}

  public getProductos(codigoSucu:number): Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(this.API_URL+'getProductos?sucursal='+codigoSucu);
  }

  public getMarcas(): Observable<Marca[]>{
    return this.httpClient.get<Marca[]>(this.API_URL+'getMarcas');
  }

  public saveProducto(producto:Producto, descipcion:String): Observable<Producto>{
    return this.httpClient.post<Producto>(this.API_URL+'saveProducto?descripcion='+descipcion,producto)
  }

  public saveMarca(marca:Marca):Observable<Marca>{
    return this.httpClient.post<Marca>(this.API_URL+'saveMarca',marca)
  }

  public saveProductoBodega(producto:Producto, marca:Marca):Observable<boolean>{
    return this.httpClient.post<boolean>(this.API_URL+'saveProductoBodega?codigoMarca='+marca.codigoId, producto)
  }

  public setProducto(producto:Producto):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'setProcuto',producto)
  }

  public setProductoMarc(producto:Producto, idMarc:number):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'setProcutoMarca?idMarca='+idMarc,producto)
  }

  public setBodegaProducto(producto:Producto):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'setBodegaProducto',producto)
  }

  public getPedidos(estado:String, codigoSucur:number): Observable<SolucionPedido[]>{
    return this.httpClient.get<SolucionPedido[]>(this.API_URL+'getPedidos?estado='+estado+'&codigo='+codigoSucur);
  }

  public solucioPedido(solPedido:SolucionPedido):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'solucionPedido', solPedido)
  }

  public rechazarPedido(solPedido:SolucionPedido):Observable<boolean>{
    return this.httpClient.put<boolean>(this.API_URL+'rechazarPedido',solPedido) 
  }

}
