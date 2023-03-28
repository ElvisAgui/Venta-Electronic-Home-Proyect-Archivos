import { CreateSecionService } from 'src/app/services/create-secion.service';
import { Producto } from 'src/class-models/producto';
import { BodegaService } from './../../../services/bodega.service';
import { Marca } from './../../../../class-models/marca';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-new-producto',
  templateUrl: './window-new-producto.component.html',
  styleUrls: ['./window-new-producto.component.css'],
})
export class WindowNewProductoComponent implements OnInit {
  crearNuevoMarca = false;
  selecMarca!: number;
  marcas: Marca[] = [];
  nombrePro: String = '';
  codigoPro: String = '';
  cantidadExiste: number = 0;
  precio: number = 0;
  descripcionPro: String = '';

  nombreMarca: String = '';
  descriptMarca: String = '';

  isModificacion = false;
  productoModificacion: Producto = new Producto();

  constructor(
    private serviBodega: BodegaService,
    private sesion: CreateSecionService
  ) {}

  ngOnInit(): void {
    //traer las marcas
    this.serviBodega.getMarcas().subscribe(
      (created: Marca[]) => {
        this.marcas = created;
      },
      (error: any) => {}
    );
    this.isModificacion = this.sesion.ismodificacion;
    this.sesion.ismodificacion = false;
    this.productoModificacion = this.sesion.productoModificacion;
    this.inicizalizarCamposModificacion();
  }

  public inicizalizarCamposModificacion() {
    if (this.isModificacion) {
      this.nombrePro = this.productoModificacion.nombre;
      this.codigoPro = this.productoModificacion.codigoProducto;
      this.cantidadExiste = this.productoModificacion.cantidad;
      this.precio = this.productoModificacion.precio;
    }
  }

  public comprobacionCamposModificion(): boolean {
    if (this.nombrePro == '') {
      return false;
    }
    if (this.codigoPro == '') {
      return false;
    }
    if (this.cantidadExiste < 0) {
      return false;
    }
    if (this.precio <= 0) {
      return false;
    }

    return true;
  }

  public actulizarProducto() {
    if (this.comprobacionCamposModificion()) {
      if (this.cambioBodegaProdcuto() && this.cambioProducto() && this.cambioProductoMarca()) {
        Swal.fire(
          'Actulizacion Completa',
          'verifique en el listado de productos',
          'success'
        );
      } else {
        Swal.fire(
          'Upss!!',
          'Ocurrio un problea al actulizar',
          'error'
        );
      }
    } else {
      Swal.fire(
        'Campos incompletos o valores erroneos',
        'todo los campos son obligatorios y debes llenarlos, el precio y cantidad deben ser mayora a 0',
        'error'
      );
    }
  }

  private cambioProducto(): boolean {
    let rte = true;
    if (this.nombreMarca != this.productoModificacion.nombre) {
      this.productoModificacion.nombre = this.nombrePro;
      this.serviBodega.setProducto(this.productoModificacion).subscribe(
        (created: boolean) => {
          rte = created;
        },
        (error: any) => {}
      );
    }
    return rte;
  }

  private cambioProductoMarca(): boolean {
    let rte = true;
    let id = 0
    if (this.selecMarca != undefined || this.precio != this.productoModificacion.precio) {
      this.productoModificacion.precio=this.precio
      if (this.selecMarca == undefined) {
        id = this.calculoidMarc()
      }else{
        id = this.marcas[this.selecMarca].codigoId
      }
      this.serviBodega.setProductoMarc(this.productoModificacion,id).subscribe(
        (created: boolean) => {
          rte = created;
        },
        (error: any) => {}
      );
    }
    return rte;
  }

  private calculoidMarc():number{
    let id=0
    for (let index = 0; index < this.marcas.length; index++) {
      const element = this.marcas[index];
      if (this.productoModificacion.marca == element.nombre) {
        id = this.marcas[index].codigoId
        break
      }
      
    }
    return id
  }

  private cambioBodegaProdcuto() {
    let rte = true;
    if (this.cantidadExiste != this.productoModificacion.cantidad) {
      this.productoModificacion.cantidad = this.cantidadExiste
      this.serviBodega.setBodegaProducto(this.productoModificacion).subscribe(
        (created: boolean) => {
          rte = created;
        },
        (error: any) => {}
      );
    }
    return rte;
  }

  public saveProductoMarca() {
    if (this.camposProductoLlenos()) {
      this.serviBodega
        .saveProducto(this.inicializadorProducto(), this.descripcionPro)
        .subscribe(
          (created: Producto) => {
            this.saveMarca(created);
          },
          (error: any) => {}
        );
    } else {
      Swal.fire(
        'Campos incompletos o valores erroneos',
        'todo los campos son obligatorios y debes llenarlos, el precio y cantidad deben ser mayora a 0',
        'error'
      );
    }
  }

  private saveMarca(producto: Producto) {
    this.serviBodega.saveMarca(this.inicilizadorMarca()).subscribe(
      (created: Marca) => {
        this.saveProductoBodega(producto, created);
      },
      (error: any) => {}
    );
  }

  private saveProductoBodega(producto: Producto, marca: Marca) {
    if (producto != null && marca != null) {
      this.serviBodega.saveProductoBodega(producto, marca).subscribe(
        (created: boolean) => {
          if (created) {
            //mensaje completado
            this.msgCompleatado();
          } else {
            this.msgError();
          }
        },
        (error: any) => {}
      );
    } else {
      //ms de error
      this.msgError();
    }
  }

  private inicializadorProducto(): Producto {
    let producto: Producto = new Producto();
    producto.nombre = this.nombrePro;
    producto.codigoProducto = this.codigoPro;
    producto.cantidad = this.cantidadExiste;
    producto.precio = this.precio;
    return producto;
  }

  private inicilizadorMarca(): Marca {
    let marca: Marca = new Marca();
    if (this.crearNuevoMarca) {
      marca.nombre = this.nombreMarca;
      marca.descripcion = this.descriptMarca;
    } else {
      marca = this.marcas[this.selecMarca];
    }
    return marca;
  }

  public crearNuevoProducto() {
    this.crearNuevoMarca = !this.crearNuevoMarca;
  }

  public imprimir() {
    console.log(this.selecMarca);
  }

  private camposProductoLlenos(): boolean {
    if (this.nombrePro == '' || this.nombrePro == undefined) {
      return false;
    }
    if (this.codigoPro == '' || this.codigoPro == undefined) {
      return false;
    }
    if (this.cantidadExiste <= 0 || this.cantidadExiste == undefined) {
      return false;
    }
    if (this.precio <= 0 || this.precio == undefined) {
      return false;
    }
    if (this.descripcionPro == '' || this.descripcionPro == undefined) {
      return false;
    }
    if (this.crearNuevoMarca) {
      if (this.nombreMarca == '' || this.nombreMarca == undefined) {
        return false;
      }
      if (this.descriptMarca == '' || this.descriptMarca == undefined) {
        return false;
      }
    } else {
      if (this.selecMarca == undefined || this.selecMarca == null) {
        return false;
      }
    }
    return true;
  }

  private msgCompleatado() {
    Swal.fire(
      'Producto creado con exito',
      'El producto ha sido creado correctamente',
      'success'
    );
  }

  private msgError() {
    Swal.fire(
      'Upss!!',
      'ha sucedido algun problema al crear el producto',
      'error'
    );
  }
}
