import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactoComponent } from './contacto/contacto.component';
import { NavbarHomeComponent } from './navbar-home/navbar-home.component';
import { TarifasComponent } from './tarifas/tarifas.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ContactoComponent,
    NavbarHomeComponent,
    TarifasComponent
  ]
})
export class ComponentesModule { }
