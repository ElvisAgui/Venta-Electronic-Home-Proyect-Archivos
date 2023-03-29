import { SucursalReport } from './../../../../class-models/sucursal-report';
import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-table-sucursale',
  templateUrl: './table-sucursale.component.html',
  styleUrls: ['./table-sucursale.component.css']
})
export class TableSucursaleComponent implements OnInit {

  Sucursales:SucursalReport[]=[]
  constructor(public sesion:CreateSecionService,
    private adminServi:AdminService) { }

  ngOnInit(): void {
    if (this.sesion.tipoReport == 8) {
      this.adminServi.getSucursalMasVentas().subscribe(
        (created:SucursalReport[]) =>{
          if (created != null) {
            this.Sucursales = created
          }else{
            Swal.fire(
              'Upss!!',
              'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
              'error'
            );
          }
        },(error:any) =>{

        }
      )
    }

    if (this.sesion.tipoReport == 9) {
      this.adminServi.getSucursalMasIngresos().subscribe(
        (created:SucursalReport[]) =>{
          if (created != null) {
            this.Sucursales = created
          }else{
            Swal.fire(
              'Upss!!',
              'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
              'error'
            );
          }
        },(error:any) =>{

        }
      )
    }
  }

}
