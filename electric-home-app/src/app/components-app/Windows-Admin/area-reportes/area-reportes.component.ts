import { AdminService } from './../../../services/admin.service';
import { CreateSecionService } from 'src/app/services/create-secion.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-area-reportes',
  templateUrl: './area-reportes.component.html',
  styleUrls: ['./area-reportes.component.css']
})
export class AreaReportesComponent implements OnInit {

  
  constructor(public sesion:CreateSecionService,
    private adminServi:AdminService) { }

  ngOnInit(): void {
   
  }

}
