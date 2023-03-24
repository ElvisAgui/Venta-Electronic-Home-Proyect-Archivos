import { CreateSecionService } from './../../../services/create-secion.service';
import { VentaService } from './../../../services/venta.service';
import { Cliente } from './../../../../class-models/cliente';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-clientes',
  templateUrl: './window-clientes.component.html',
  styleUrls: ['./window-clientes.component.css'],
})
export class WindowClientesComponent implements OnInit {
  clientes: Cliente[] = [];
  cliente: Cliente = new Cliente();
  nit = '';
  nombre = '';
  apellido = '';
  index = 0;

  constructor(
    private serviceVenta: VentaService,
    private sesion: CreateSecionService
  ) {
    this.clientes = sesion.clientes;
  }

  ngOnInit(): void {}

  public setCliente(index: number) {
    this.cliente = this.clientes[index];
    this.nit = this.cliente.nit + '';
    this.apellido = this.cliente.apellido + '';
    this.nombre = this.cliente.nombre + '';
    this.index = index;
  }

  public modificar(index: number) {
    if (this.datosLlenos()) {
      this.setClienteService(this.comprovarSiUboCambio(index), index)
    }else{
      Swal.fire(
        'Upss!',
        'Tines que indicar que usuario quieres Actulizar',
        'error'
      );
    }
  }

  private setClienteService(cambiarDB:boolean, index:number){
    if (cambiarDB) {
      this.cliente.nombre = this.nombre
      this.cliente.apellido = this.apellido
      this.serviceVenta.setCliente(this.cliente).subscribe(
        (created: Cliente) =>{
          this.clientes[index] = created;
          this.nit = '';
          this.nombre = '';
          this.apellido = '';
          this.index = 0;
        },
        (error: any) =>{

        }
      );
    }else{
      this.clientes[index] = this.cliente;
      this.nit = '';
      this.nombre = '';
      this.apellido = '';
      this.index = 0;
    }
  }

  private comprovarSiUboCambio(index:number): boolean{
    let clt = this.clientes[index]
    if (clt.nombre != this.nombre) {
      return true;
    }
    if (clt.apellido != this.apellido) {
      return true
    }
    return false
  }

  private datosLlenos(): boolean {
    if (this.nit === undefined || this.nit === '') {
      return false;
    }
    if (this.nombre === undefined || this.nombre === '') {
      return false;
    }
    if (this.apellido === undefined || this.apellido === '') {
      return false;
    }
    return true;
  }
}
