import { ItemProducto } from './../../../../class-models/item-producto';
import { Producto } from './../../../../class-models/producto';
import { VentaService } from './../../../services/venta.service';
import { Cliente } from './../../../../class-models/cliente';
import { VentaProducto } from './../../../../class-models/venta-producto';
import { ItemsVenta } from './../../../../class-models/items-venta';
import { Router } from '@angular/router';
import { CreateSecionService } from './../../../services/create-secion.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-venta',
  templateUrl: './window-venta.component.html',
  styleUrls: ['./window-venta.component.css'],
})
export class WindowVentaComponent implements OnInit {
  itemsVenta: ItemsVenta[]= [];
  itemProducto :ItemProducto[] = [];
  ventaProducto: VentaProducto = new VentaProducto();
  cliente: Cliente = new Cliente();
  nit!: number;
  nombreCliente: String = '';
  apellidoCliente: String = '';
  bloquearInputs = false;
  codigoProducto: String = '';
  cantidadProducto:number = 0
  descuentoCompra:number=0
  ocultarTotales = true
  descuentoPorcen=""
  ocularSave = false
  clienteExiste = false

  constructor(
    private sesionServi: CreateSecionService,
    private router: Router,
    private ventaServi: VentaService,
  ) {}

  ngOnInit(): void {}

  public nitVacio(): boolean {
    return this.nit === undefined || this.nit+"" ==="" ;
  }

  /**
   * comprueba si la cantidad de producto ingresada en el input es negativa o cero
   * @returns true si es 0 o menos 
   */
  public isCantidadCero():boolean{
    if (this.cantidadProducto <= 0) {
      Swal.fire(
        'Valor Invalido',
        'Solo puedes comprar productos con cantidades mayores a  0',
        'error'
      );
      return true
    }
    return false
  }

  /**
   * obtiene el cliente para la venta
   */
  public getCliente() {
    this.ventaServi.getCliente(this.nit, false).subscribe(
      (created: Cliente) => {
        this.aletClienteNoRegi(created, false);

      },
      (erro: any) => {
        //error al obtener la sucursal
      }
    );
  }

  private getDescuento(isConsumidorF:boolean, nit:String){
    if (isConsumidorF) {
      this.descuentoCompra = 0
    } else {
      this.ventaServi.getDescuento(nit).subscribe(
        (created:VentaProducto)=>{
          this.descuentoCompra = created.descuento
        },
        (erro:any)=>{

        }
      );
    }
  }

  /**
   * obtiene los datos del consumidor fianl
   */
  public getClienteConsuF() {
    this.ventaServi.getCliente(this.nit, true).subscribe(
      (created: Cliente) => {
        this.clienteExiste = true
        this.aletClienteNoRegi(created, true);
      },
      (erro: any) => {
        //error al obtener la sucursal
      }
    );
  }

  /**
   * indica si el cliente no se ha encontrado en la DB
   * @param cliente 
   */
  public aletClienteNoRegi(cliente: Cliente, isConsuF:boolean) {
    if (cliente === undefined || cliente === null) {
      Swal.fire(
        'Usuario no Registrado',
        'Debes llenar los campos de nombres, y apellido, Manualmente para Registrar al Cliente',
        'info'
      );
    } else {
      this.clienteExiste = true
      this.cliente = cliente;
      this.bloquearInputs = true;
      this.nombreCliente = cliente.nombre;
      this.apellidoCliente = cliente.apellido;
      this.getDescuento(isConsuF, this.cliente.nit+"")
      
    }
  }


  /**
   * obtiene los datos del producto de la DB 
   */
  public getProducto() {
    if (!this.isCantidadCero()) {
      this.ventaServi
      .getProducto(
        this.sesionServi.sucursalContratado.codigoId,
        this.codigoProducto
      )
      .subscribe(
        (create: Producto) => {
          this.acctionAddProductoList(create)
        },
        (error: any) => {

        }
      );
    }
  }

  private acctionAddProductoList(create:Producto){
    if (this.isExisitenteProducto(create) && this.productoIsComprable(create) && !this.existeEnArray(create)) {
      this.addItemProducto(create)
      this.addItemVentaProd(create)
    }
    
  }

  private isExisitenteProducto(producto:Producto): boolean{
    if (producto === null || producto === undefined) {
      Swal.fire(
        'Producto no Existente en la Sucursal',
        'Debe solicitar al encargado de inventario que Solicite el prodcuto en bodega u otra sucursal',
        'error'
      );
      return false
    }
    return true
  }

  private productoIsComprable(producto:Producto): boolean{
    if(producto.cantidad < this.cantidadProducto){
      Swal.fire(
        'Solo hay ' + producto.cantidad+ ' en Existencia ',
        'No puedes comprar mas productos de los que hay en existencia en la Sucursal',
        'error'
      );
      return false
    }
    return true
  }

  /**
   * agrega un nuevo itema para mostrar en la tabla de la venta
   * @param producto 
   */
  private addItemProducto(producto:Producto){
    let itemProTem = new ItemProducto()
    itemProTem.cantidad = this.cantidadProducto
    itemProTem.marcaProducto=producto.marca
    itemProTem.nameProducto=producto.nombre
    itemProTem.precio = producto.precio
    itemProTem.total = producto.precio*this.cantidadProducto
    this.itemProducto.push(itemProTem)
  }

  /**
   * agreaga otro item de la venta, este es para la insercion a la DB
   */
  private addItemVentaProd(producto:Producto){
    let itemVentProd = new ItemsVenta()
    itemVentProd.cantidadProducto = this.cantidadProducto
    itemVentProd.codigoProducto = producto.codigoId
    itemVentProd.codigoVentaProducto = this.ventaProducto.codigo
    this.itemsVenta.push(itemVentProd)
  }

  public existeEnArray(producto:Producto):boolean{
    let valor = false
    if (this.itemsVenta.length ==0) {
      return valor
    }else{
      for (let index = 0; index < this.itemsVenta.length; index++) {
        const element = this.itemsVenta[index];
        if (producto.codigoId == element.codigoProducto) {
          valor = true
          Swal.fire(
            'ERRO AL AGREGAR EL PRODUCTO',
            'el producto ya existe en la compra, si desea aumentar la cantidad, debera eliminar y agregar nuevamente con la cantidad nueva',
            'info'
          );
          break;
        }
      }
      return valor
    }
  }


  public quitLisProdcuto(index:number){
    this.itemsVenta.splice(index,1)
    this.itemProducto.splice(index,1)
  }

  /**
   * funcion que registra el cliente si es que no existe en la DB
   */
  public saveCliente() {
    this.cliente.nit = this.nit;
    this.cliente.nombre = this.nombreCliente;
    this.cliente.apellido = this.apellidoCliente;
    if (this.compraDatosClin()) {
      this.ventaServi.createdCliente(this.cliente).subscribe(
        (created: Cliente) => {
          this.cliente = created;
          this.saveVenta()
        },
        (error: any) => {}
      );
    }else{
      Swal.fire(
        'ERRO AL REGISTRAR LA COMPRA',
        'Debe llenar los datos del clinte',
        'error'
      );
    }
  }

  private compraDatosClin(): boolean{
    if (this.cliente.apellido === undefined || this.cliente.apellido === '') {
      return false
    }
    if (this.cliente.nombre === undefined || this.cliente.nombre === '') {
      return false
    }
    if (this.nit === undefined || this.nit+"" ==="" ) {
      return false
    }
    return true
  }

  public saveVentaClick(){
    if (this.itemsVenta.length != 0) {
      if (this.clienteExiste) {
        this.saveVenta()
      }else{
        this.saveCliente()
      }
    }else{
      Swal.fire(
        'ERRO AL REGISTRAR LA COMPRA',
        'Debe comprar almenos un producto',
        'error'
      );
    }
  }

  public saveVenta(){
    this.constructorVenta(this.cliente);
    this.ventaServi.saveVenta(this.ventaProducto).subscribe(
      (created:VentaProducto) => {
        if (created !== null && created !== undefined ) {
          this.saveItemVenta(created.codigo, created.codigoSucursal)
        }else{
          //mensaje de error al ingresar la venta
          Swal.fire(
            'ERRO AL REGISTRAR LA COMPRA',
            'Intente actulizar la pagina en el boton de RESTALL',
            'error'
          );
        }
      },
      (error:any)=>{

      }
    );
  }

  /**
   * construye la venta en base a los parametros de la compra, esta es la que se registra en la DB
   * @param cliente 
   * @param calcularDescuento 
   */
  private constructorVenta(cliente:Cliente){
    this.ventaProducto.codigo = 'ventaN'
    this.ventaProducto.cantidadProducto = this.calcularTotalProducto()
    this.ventaProducto.totalGastado = this.calcularTotalGastado()
    this.ventaProducto.descuento = this.calcularDescuento(this.descuentoCompra,this.ventaProducto.totalGastado)
    this.ventaProducto.ganaciaReal = Number((this.ventaProducto.totalGastado-this.ventaProducto.descuento).toFixed(2))
    this.ventaProducto.cuiEempleado = this.sesionServi.usuario.cui
    this.ventaProducto.nitCliente = cliente.nit+''
    this.ventaProducto.codigoSucursal = this.sesionServi.sucursalContratado.codigoId
  }

  private calcularDescuento(gastoAnterio:number, gastoActual:number): number{
    if (gastoAnterio >= 1000 && gastoAnterio < 5000) {
      this.descuentoPorcen = "2"
      return Number((gastoActual*0.02).toFixed(2));
    }
    if (gastoAnterio >= 5000 && gastoAnterio < 10000) {
      this.descuentoPorcen = "5"
      return Number((gastoActual*0.05).toFixed(2));
    }
    if (gastoAnterio >= 10000) {
      this.descuentoPorcen = "10"
      return Number((gastoActual*0.10).toFixed(2));
    }
    return 0
  }

  /**
   * recore los productos y suma el total para tener un total de la compra
   * @returns total gastado en la compra
   */
  private calcularTotalGastado(): number{
    let totalGastado: number = 0
    this.itemProducto.forEach(producto => {
      totalGastado += producto.total
    });
    return Number(totalGastado.toFixed(2))
  }

  private calcularTotalProducto(): number{
    let totalProducto:number = 0
    this.itemsVenta.forEach(item => {
      totalProducto += item.cantidadProducto
    });
    return totalProducto
  }

  public saveItemVenta(codigoVenta:String, codigoSucural:number){
    this.actualizarCodigoVenta(codigoVenta)
    this.ventaServi.saveItemVenta(this.itemsVenta, codigoSucural).subscribe(
      (created:boolean) => {
        this.ocularSave = created
        this.ocultarTotales = !created
        this.msgFinalSatisfactori()
      },
      (error:any) => {

      }
    );
  }


  private msgFinalSatisfactori(){
    Swal.fire(
      'Compra Realizada con exito',
      'Revise si el cliente tiene descuentos',
      'success'
    );
  }

  private actualizarCodigoVenta(codigoVenta:String){
    this.itemsVenta.forEach(item => {
      item.codigoVentaProducto = codigoVenta
    });
  }

  reloadPage() {
    console.log(this.getCurrentUrl())
    if (this.getCurrentUrl()+"" == '/Area-Ventas/ventas/new') {
      this.router.navigate(['Area-Ventas/ventas'])
    }else{
      this.router.navigate(['Area-Ventas/ventas/new'])
    }
    
  }

  getCurrentUrl() {
    return this.router.url;
  }
  
}
