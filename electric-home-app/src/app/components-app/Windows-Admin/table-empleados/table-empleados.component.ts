import { EmpleadoReport } from './../../../../class-models/empleado-report';
import { AdminService } from 'src/app/services/admin.service';
import { Component, OnInit } from '@angular/core';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-table-empleados',
  templateUrl: './table-empleados.component.html',
  styleUrls: ['./table-empleados.component.css']
})
export class TableEmpleadosComponent implements OnInit {

  empleados:EmpleadoReport[]=[]

  constructor(public sesion:CreateSecionService,
    private adminServi:AdminService) { }

  ngOnInit(): void {
    if (this.sesion.tipoReport == 2) {
      this.adminServi.getReportEmpleadoMasVenta().subscribe(
        (created:EmpleadoReport[]) =>{
          if (created != null) {
            this.empleados = created
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
    }else{
      if (this.sesion.tipoReport == 3) {
        this.adminServi.getReportEmpleadoMasIngresos().subscribe(
          (created:EmpleadoReport[]) =>{
            if (created != null) {
              this.empleados = created
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

    


}
