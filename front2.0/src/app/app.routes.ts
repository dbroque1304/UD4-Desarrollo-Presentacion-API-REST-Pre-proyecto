import { Routes } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { EventoComponent } from './componentes/evento/evento.component';
import { HorarioComponent } from './componentes/horario/horario.component';
import { ProfesorComponent } from './componentes/profesor/profesor.component';
import { TarifasComponent } from './componentes/tarifas/tarifas.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
    {path: "home", component: HomeComponent},
    {path: "eventos", component: EventoComponent},
    {path: "horario", component: HorarioComponent},
    {path: "profesores", component: ProfesorComponent},
    {path: "tarifas", component: TarifasComponent},
    {path: "contacto", component: ContactoComponent},
    {path: "login", component:LoginComponent},
    {path: "register", component:RegisterComponent}
];
