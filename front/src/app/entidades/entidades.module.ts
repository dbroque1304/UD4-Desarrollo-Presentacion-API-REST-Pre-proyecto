import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArteMarcialComponent } from './arte-marcial/arte-marcial.component';
import { HorarioComponent } from './horario/horario.component';
import { MaestroComponent } from './maestro/maestro.component';
import { SesionComponent } from './sesion/sesion.component';
import { UsuarioComponent } from './usuario/usuario.component';



@NgModule({
  declarations: [
    ArteMarcialComponent,
    HorarioComponent,
    MaestroComponent,
    SesionComponent,
    UsuarioComponent
  ],
  imports: [
    CommonModule
  ]
})
export class EntidadesModule { }
