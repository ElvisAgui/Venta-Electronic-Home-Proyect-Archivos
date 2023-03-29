import { ClienteReport } from './../../../../class-models/cliente-report';
import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-table-clientes',
  templateUrl: './table-clientes.component.html',
  styleUrls: ['./table-clientes.component.css']
})
export class TableClientesComponent implements OnInit {

  clienteRepo:ClienteReport[]= []
  constructor(private sesion:CreateSecionService,
    private adminServi:AdminService) { }

  ngOnInit(): void {
    if (this.sesion.tipoReport == 1) {
      this.adminServi.getReporteClientes().subscribe(
        (created:ClienteReport[]) =>{
          if (created != null) {
            this.clienteRepo = created
          }else{
            Swal.fire(
              'Upss!!',
              'Ubo un error al momento de la peticion de datos del reporte, comuniquese con el desarrodor',
              'error'
            );
          }
        },(error:any) =>{

        });
    }
  }

}
