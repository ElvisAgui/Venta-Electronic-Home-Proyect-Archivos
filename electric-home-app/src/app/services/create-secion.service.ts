import { Injectable } from '@angular/core';
import { Usuario } from 'src/class-models/usuario';

@Injectable({
  providedIn: 'root'
})
export class CreateSecionService {
  
  usuario!: Usuario;
  
  constructor() { }
}
