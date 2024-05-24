import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EventoComponent } from './components/evento/evento.component';
import { HorarioComponent } from './components/horario/horario.component';
import { ProfesorComponent } from './components/profesor/profesor.component';
import { TarifasComponent } from './components/tarifas/tarifas.component';
import { ContactoComponent } from './components/contacto/contacto.component';

export const routes: Routes = [
    {path: "home", component: HomeComponent},
    {path: "eventos", component: EventoComponent},
    {path: "horario", component: HorarioComponent},
    {path: "profesores", component: ProfesorComponent},
    {path: "tarifas", component: TarifasComponent},
    {path: "contacto", component: ContactoComponent}
];
