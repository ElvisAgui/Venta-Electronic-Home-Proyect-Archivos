import { WindowPedidosComponent } from './components-app/windows-Inventario/window-pedidos/window-pedidos.component';
import { WindowNewProductoComponent } from './components-app/windows-Inventario/window-new-producto/window-new-producto.component';
import { WindowProductosComponent } from './components-app/Windows-Ventas/window-productos/window-productos.component';
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
    path:'Area-Ventas/productos',
    component: WindowProductosComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Inventario/perfil',
    component: WindowHomeVentaComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Inventario/productos',
    component: WindowProductosComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Inventario/newProducto',
    component: WindowNewProductoComponent,
    canActivate: [AutenticacionService],
  },
  {
    path:'Area-Inventario/pedidos',
    component:WindowPedidosComponent,
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
