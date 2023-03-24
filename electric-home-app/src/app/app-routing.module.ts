import { WindowClientesComponent } from './components-app/Windows-Ventas/window-clientes/window-clientes.component';
import { WindowVentaComponent } from './components-app/Windows-Ventas/window-venta/window-venta.component';
import { WindowHomeVentaComponent } from './components-app/Windows-Ventas/window-home-venta/window-home-venta.component';
import { WindowRootComponent } from './components-app/window-root/window-root.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AutenticacionService } from './services/autenticacion.service';

const routes: Routes = [
  {
    path: '',
    component: WindowRootComponent,
  },
  {
    path:'Area-Ventas/perfil',
    component: WindowHomeVentaComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Ventas/ventas',
    component: WindowVentaComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Ventas/ventas/new',
    component: WindowVentaComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Ventas/clientes',
    component: WindowClientesComponent,
    canActivate: [AutenticacionService],
  },
  {
    path: '**',
    component: WindowRootComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
