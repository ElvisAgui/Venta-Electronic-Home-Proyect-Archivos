import { Component, OnInit } from '@angular/core';
import { BodegaService } from 'src/app/services/bodega.service';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { SolucionPedido } from 'src/class-models/solucion-pedido';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-window-pedidos-bodega',
  templateUrl: './window-pedidos-bodega.component.html',
  styleUrls: ['./window-pedidos-bodega.component.css']
})
export class WindowPedidosBodegaComponent implements OnInit {

  pediosSol:SolucionPedido[] = []

  constructor(
    private bodegaServi: BodegaService,
    private sesion: CreateSecionService
  ) {}

  ngOnInit(): void {
    this.bodegaServi.getPedidos("Enviado",this.sesion.bodegaContratado.codigoId).subscribe(
      (created: SolucionPedido[]) => {
        if (created != null) {
          console.log(created)
          this.pediosSol = created
        }
      },(error: any) => {}
    )
  }

  public enviarRespuestaPedido(index:number){
    let solPedido = this.pediosSol[index]
    solPedido.codigoSucursal = this.codigoSucursalSolicitante(solPedido)
    solPedido.estado = 'Aceptado'
    this.bodegaServi.solucioPedido(solPedido).subscribe(
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


  public rechazarPedido(index:number){
    this.bodegaServi.rechazarPedido(this.pediosSol[index]).subscribe(
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
