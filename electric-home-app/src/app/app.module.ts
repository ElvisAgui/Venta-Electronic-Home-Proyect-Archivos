import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WindowHomeVentaComponent } from './components-app/Windows-Ventas/window-home-venta/window-home-venta.component';
import { WindowRootComponent } from './components-app/window-root/window-root.component';
import { NavbarVentasComponent } from './components-app/Windows-Ventas/navbar-ventas/navbar-ventas.component';
import { FooterComponent } from './components-app/window-root/footer/footer.component';
import { WindowVentaComponent } from './components-app/Windows-Ventas/window-venta/window-venta.component';
import { WindowClientesComponent } from './components-app/Windows-Ventas/window-clientes/window-clientes.component';
import { WindowProductosComponent } from './components-app/Windows-Ventas/window-productos/window-productos.component';
import { NavbarInventarioComponent } from './components-app/windows-Inventario/navbar-inventario/navbar-inventario.component';
import { WindowNewProductoComponent } from './components-app/windows-Inventario/window-new-producto/window-new-producto.component';
import { WindowPedidosComponent } from './components-app/windows-Inventario/window-pedidos/window-pedidos.component';
import { NavbarBodegaComponent } from './components-app/Windows-Bodega/navbar-bodega/navbar-bodega.component';
import { WindowPerfilComponent } from './components-app/Windows-Bodega/window-perfil/window-perfil.component';
import { WindowProductosBodegaComponent } from './components-app/Windows-Bodega/window-productos-bodega/window-productos-bodega.component';
import { WindowPedidosBodegaComponent } from './components-app/Windows-Bodega/window-pedidos-bodega/window-pedidos-bodega.component';

@NgModule({
  declarations: [
    AppComponent,
    WindowRootComponent,
    WindowHomeVentaComponent,
    NavbarVentasComponent,
    FooterComponent,
    WindowVentaComponent,
    WindowClientesComponent,
    WindowProductosComponent,
    NavbarInventarioComponent,
    WindowNewProductoComponent,
    WindowPedidosComponent,
    NavbarBodegaComponent,
    WindowPerfilComponent,
    WindowProductosBodegaComponent,
    WindowPedidosBodegaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
