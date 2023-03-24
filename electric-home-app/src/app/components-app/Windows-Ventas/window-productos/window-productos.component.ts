import { Producto } from 'src/class-models/producto';
import { CreateSecionService } from './../../../services/create-secion.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-window-productos',
  templateUrl: './window-productos.component.html',
  styleUrls: ['./window-productos.component.css']
})
export class WindowProductosComponent implements OnInit {

  productos:Producto[]=[]
  constructor(private sesion:CreateSecionService) { 
    this.productos = this.sesion.porductos
  }

  ngOnInit(): void {
  }

}
