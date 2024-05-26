import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { NavbarHomeComponent } from './componentes/navbar-home/navbar-home.component';
import { TarifasComponent } from './componentes/tarifas/tarifas.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: []
})
export class AppModule { }
