import { ProductoReport } from './../../../../class-models/producto-report';
import { AdminService } from 'src/app/services/admin.service';
import { Component, OnInit } from '@angular/core';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-table-productos',
  templateUrl: './table-productos.component.html',
  styleUrls: ['./table-productos.component.css'],
})
export class TableProductosComponent implements OnInit {
  productos: ProductoReport[] = [];
  codigoSucursal = 1;
  nameSucursal = 'Sucursal Central';

  constructor(
    public sesion: CreateSecionService,
    private adminServi: AdminService
  ) {}

  ngOnInit(): void {
    if (this.sesion.tipoReport == 4) {
      this.adminServi.getProductoMasVendido().subscribe(
        (created: ProductoReport[]) => {
          if (created != null) {
            this.productos = created;
          } else {
            Swal.fire(
              'Upss!!',
              'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
              'error'
            );
          }
        },
        (error: any) => {}
      );
    }
    if (this.sesion.tipoReport == 5) {
      this.adminServi.getProductoMasIngreso().subscribe(
        (created: ProductoReport[]) => {
          if (created != null) {
            this.productos = created;
          } else {
            Swal.fire(
              'Upss!!',
              'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
              'error'
            );
          }
        },
        (error: any) => {}
      );
    }
    if (this.sesion.tipoReport == 6) {
      this.adminServi
        .getProductoMasVendidoSucursal(this.codigoSucursal)
        .subscribe(
          (created: ProductoReport[]) => {
            if (created != null) {
              this.productos = created;
            } else {
              Swal.fire(
                'Upss!!',
                'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
                'error'
              );
            }
          },
          (error: any) => {}
        );
    }
    if (this.sesion.tipoReport == 7) {
      this.adminServi
        .getProductoMasIngresosSucursal(this.codigoSucursal)
        .subscribe(
          (created: ProductoReport[]) => {
            if (created != null) {
              this.productos = created;
            } else {
              Swal.fire(
                'Upss!!',
                'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
                'error'
              );
            }
          },
          (error: any) => {}
        );
    }
  }

  public cambioSucursa(index: number) {
    if (this.sesion.tipoReport == 6) {
      this.codigoSucursal = index;
      this.cambioNameSucursal()
      this.adminServi
        .getProductoMasVendidoSucursal(this.codigoSucursal)
        .subscribe(
          (created: ProductoReport[]) => {
            if (created != null) {
              this.productos = created;
            } else {
              Swal.fire(
                'Upss!!',
                'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
                'error'
              );
            }
          },
          (error: any) => {}
        );
    }
    if (this.sesion.tipoReport == 7) {
      this.codigoSucursal = index;
      this.cambioNameSucursal()
      this.adminServi
        .getProductoMasIngresosSucursal(this.codigoSucursal)
        .subscribe(
          (created: ProductoReport[]) => {
            if (created != null) {
              this.productos = created;
            } else {
              Swal.fire(
                'Upss!!',
                'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
                'error'
              );
            }
          },
          (error: any) => {}
        );
    }
  }

  public cambioNameSucursal() {
    switch (this.codigoSucursal) {
      case 1:
        this.nameSucursal = 'Sucursal Central';
        break;
      case 2:
        this.nameSucursal = 'Sucursal Norte';
        break;
      case 3:
        this.nameSucursal = 'Sucursal Sur';
        break;

      default:
        this.nameSucursal = '';
        break;
    }
  }
}
