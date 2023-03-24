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

@NgModule({
  declarations: [
    AppComponent,
    WindowRootComponent,
    WindowHomeVentaComponent,
    NavbarVentasComponent,
    FooterComponent,
    WindowVentaComponent,
    WindowClientesComponent
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
