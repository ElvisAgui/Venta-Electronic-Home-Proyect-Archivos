import { Bodega } from './../../class-models/bodega';
import { Producto } from 'src/class-models/producto';
import { Sucursal } from './../../class-models/sucursal';
import { Injectable } from '@angular/core';
import { Usuario } from 'src/class-models/usuario';
import { Cliente } from 'src/class-models/cliente';

@Injectable({
  providedIn: 'root'
})
export class CreateSecionService {
  
  usuario!: Usuario;
  sucursalContratado!:Sucursal;
  bodegaContratado!:Bodega
  clientes:Cliente[]=[]
  porductos:Producto[]=[]
  ismodificacion= false

  productoModificacion:Producto= new Producto()

  constructor() { }


  get getUsuario(){
    return this.usuario;
  }
  
  set setUsuario(usuario: Usuario){
    this.usuario = usuario;
  }
}
