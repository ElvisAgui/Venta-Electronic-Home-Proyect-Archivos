import { SolucionPedido } from './../../../../class-models/solucion-pedido';
import { Pedido } from './../../../../class-models/pedido';
import { Bodega } from './../../../../class-models/bodega';
import { CreateSecionService } from './../../../services/create-secion.service';
import { InventarioService } from './../../../services/inventario.service';
import { Component, OnInit } from '@angular/core';
import { Sucursal } from 'src/class-models/sucursal';
import { Producto } from 'src/class-models/producto';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-pedidos',
  templateUrl: './window-pedidos.component.html',
  styleUrls: ['./window-pedidos.component.css'],
})
export class WindowPedidosComponent implements OnInit {
  sucursales: Sucursal[] = [];
  sucursalPedido: Sucursal = new Sucursal();
  bodega: Bodega = new Bodega();
  eligioBodega = true;
  codigoProducto = '';
  cantidadProducto = 0;
  pediosSol:SolucionPedido[] = []

  constructor(
    private inventServi: InventarioService,
    private sesion: CreateSecionService
  ) {}

  ngOnInit(): void {
    this.inventServi.getSucursales().subscribe(
      (created: Sucursal[]) => {
        if (created != null) {
          this.sucursales = this.limpiarSucursales(created);
        }
      },
      (error: any) => {}
    );
    this.inventServi.getPedidos("Enviado",this.sesion.sucursalContratado.codigoId).subscribe(
      (created: SolucionPedido[]) => {
        if (created != null) {
          this.pediosSol = created
        }
      },(error: any) => {}
    )
  }

  public realizarPedido(){
    if (this.eligioBodega) {
      this.getProductoBodega()
    }else{
      this.getProducto()
    }
  }

  public savePedido(producto: Producto) {
    if (this.cantidadProducto != 0 && this.codigoProducto != '') {
      if (this.existeProducto(producto) && this.isCantidadAceptable(producto)) {
        let pedido = new Pedido();
        pedido.cantidad = this.cantidadProducto;
        pedido.codigoProducto = producto.codigoId;
        pedido.cuiEmpleado = this.sesion.usuario.cui;
        pedido.estado = 'Enviado';
        pedido.sucuralSolicitante = this.sesion.sucursalContratado.nombre
        if (this.eligioBodega) {
          pedido.codigoSucursal = 0;
          pedido.codigoBodega = this.bodega.codigoId;
        } else {
          pedido.codigoSucursal = this.sucursalPedido.codigoId;
          pedido.codigoBodega = 0;
        }
        this.inventServi.savePedido(pedido).subscribe(
          (create: boolean) => {
            this.msgSolicitud(create);
          },
          (error: any) => {}
        );
      }
    } else {
      Swal.fire('Upss!', 'Debes llenar los campos de la solicitud', 'error');
    }
  }

  private msgSolicitud(result: boolean) {
    if (result) {
      Swal.fire(
        'Completado',
        'Su solicitud de pedido fue enviada con exito',
        'success'
      );
    } else {
      Swal.fire(
        'Upss!!',
        'Su solicitud de pedido NO fue enviada con exito, envia de nuevo o consulta con el desarrollador :V',
        'error'
      );
    }
  }

  public enviarRespuestaPedido(index:number){
    let solPedido = this.pediosSol[index]
    solPedido.codigoSucursal = this.codigoSucursalSolicitante(solPedido)
    solPedido.estado = 'Aceptado'
    this.inventServi.solucioPedido(solPedido, this.sesion.sucursalContratado).subscribe(
      (created:boolean)=>{
        this.msgSolPedido(created, index)
      },
      (error: any) => {}
    )
  }

  private codigoSucursalSolicitante(solPedido:SolucionPedido):number{
    if (solPedido.sucuralSolicitante =='Sucursal Central') {
      return 1
    }
    if (solPedido.sucuralSolicitante == 'Sucursal Norte') {
      return 2
    }

    return 3
  }

  private msgSolPedido(sol:boolean, index:number){
    if (sol) {
      Swal.fire(
        'Eviado',
        'El producto y cantidad han sido enviado exitosamente',
        'success'
      );
      this.pediosSol.splice(index,1)
    } else {
      Swal.fire(
        'Upss!!',
        'Su solicitud de pedido NO fue procesada con exito',
        'error'
      );
    }
  }

  /**
   * obtiene los datos del producto de la DB
   */
  public getProducto() {
    if (!this.isCantidadCero()) {
      this.inventServi
        .getProducto(
          this.sucursalPedido.codigoId,
          this.codigoProducto
        )
        .subscribe(
          (create: Producto) => {
            this.savePedido(create);
          },
          (error: any) => {}
        );
    }
  }

   /**
   * obtiene los datos del producto de la DB de la bodega
   */
    public getProductoBodega() {
      if (!this.isCantidadCero()) {
        this.inventServi
          .getProductoBodega(
            this.bodega.codigoId,
            this.codigoProducto
          )
          .subscribe(
            (create: Producto) => {
              this.savePedido(create);
            },
            (error: any) => {}
          );
      }
    }

  private existeProducto(producto: Producto): boolean {
    if (producto === null || producto === undefined) {
      Swal.fire(
        'Upss!',
        'El producto que intentas solicitar no existe en el inventario de origen',
        'info'
      );
      return false;
    }
    return true;
  }

  private isCantidadAceptable(producto: Producto): boolean {
    if (producto.cantidad < this.cantidadProducto) {
      Swal.fire(
        'Upss!',
        'el origen del pedido solo cuenta con ' +
          producto.cantidad +
          ' unidades de existencia no puedes solicitar mas que eso',
        'info'
      );
      return false;
    }
    return true;
  }

  /**
   * comprueba si la cantidad de producto ingresada en el input es negativa o cero
   * @returns true si es 0 o menos
   */
  public isCantidadCero(): boolean {
    if (this.cantidadProducto <= 0) {
      Swal.fire(
        'Valor Invalido',
        'Solo puedes Solicitar productos con cantidades mayores a  0',
        'error'
      );
      return true;
    }
    return false;
  }

  public limpiarSucursales(created: Sucursal[]): Sucursal[] {
    for (let index = 0; index < created.length; index++) {
      const element = created[index];
      if (element.codigoId == this.sesion.sucursalContratado.codigoId) {
        created.splice(index, 1);
        break;
      }
    }
    return created;
  }

  public selecSucursal(index: number) {
    if (index == -1) {
      this.eligioBodega = true;
      this.inventServi.getBodegas().subscribe(
        (created: Bodega[]) => {
          if (created != null) {
            this.bodega = created[0];
          }
        },
        (error: any) => {}
      );
    } else {
      this.eligioBodega = false;
      this.sucursalPedido = this.sucursales[index];
    }
  }

  public rechazarPedido(index:number){
    this.inventServi.rechazarPedido(this.pediosSol[index]).subscribe(
      (created:boolean)=>{
        if (created) {
          Swal.fire(
            'Rechazado con exito',
            'Debes comunicarte con el solicitante para indicarle el motivo del rechazo',
            'info'
          );
          this.pediosSol.splice(index,1)
        } else {
          Swal.fire(
            'Error en el Rechazo',
            'A ocurrido un error y no se pudo rechazar la solicitud',
            'error'
          );
        }
      },
      (error: any) => {}
    );
  }
}
