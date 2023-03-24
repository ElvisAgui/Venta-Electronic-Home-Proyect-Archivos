import { ItemsVenta } from './../../class-models/items-venta';
import { VentaProducto } from './../../class-models/venta-producto';
import { Cliente } from './../../class-models/cliente';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from 'src/class-models/producto';

@Injectable({
  providedIn: 'root',
})
export class VentaService {
  readonly API_URL = 'http://localhost:8080/Electronic-Home/venta/';
  constructor(private httpClient: HttpClient) {}

  public getCliente(
    nit: number,
    isConsumidorFinal: boolean
  ): Observable<Cliente> {
    if (isConsumidorFinal) {
      return this.httpClient.get<Cliente>(
        this.API_URL + 'getCliente?nit=' + '86316443'
      );
    } else {
      return this.httpClient.get<Cliente>(
        this.API_URL + 'getCliente?nit=' + nit + ''
      );
    }
  }

  public createdCliente(cliente: Cliente): Observable<Cliente> {
    return this.httpClient.post<Cliente>(
      this.API_URL + 'saveCliente',cliente
    );
  }

  public getProducto(codigoSucu:number, codigoPro:String): Observable<Producto>{
    return this.httpClient.get<Producto>(this.API_URL+'getProducto?sucursal='+codigoSucu+'&producto='+codigoPro);
  }

  public getDescuento(nit:String): Observable<VentaProducto>{
    return this.httpClient.get<VentaProducto>(this.API_URL+'getDescuento?nit='+nit);
  }

  public saveVenta(venta:VentaProducto): Observable<VentaProducto>{
    return this.httpClient.post<VentaProducto>(this.API_URL+'saveVenta?gana='+venta.ganaciaReal+'&cui='+venta.cuiEempleado, venta);
  }

  public saveItemVenta(itemsVenta: ItemsVenta[], codigoSucursal:number): Observable<boolean>{
    return this.httpClient.post<boolean>(this.API_URL+'saveItemVenta?codigoSucural='+codigoSucursal, itemsVenta);
  }

  public getClientes():Observable <Cliente[]>{
    return this.httpClient.get<Cliente[]>(this.API_URL+'getClientes')
  }

  public setCliente(cliente:Cliente):Observable<Cliente>{
    return this.httpClient.put<Cliente>(this.API_URL+'setCliente', cliente)
  }
  
}
