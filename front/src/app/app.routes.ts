import { Routes, provideRouter } from '@angular/router';
import { EventoComponent } from './componentes/evento/evento.component';
import { HorarioComponent } from './componentes/horario/horario.component';
import { TarifasComponent } from './componentes/tarifas/tarifas.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MaestrosComponent } from './maestros/maestros.component';
import { MaestroComponent } from './entidades/maestro/maestro.component';
import { SesionComponent } from './entidades/sesion/sesion.component';
import { UsuarioComponent } from './entidades/usuario/usuario.component';
import { ArtemarcialComponent } from './entidades/artemarcial/artemarcial.component';
import { AdminAuthGuardComponent } from './admin-auth-guard/admin-auth-guard.component';
import { AdminComponent } from './admin/admin.component';

export const routes: Routes = [
    {path: "eventos", component: EventoComponent},
    {path: "horario", component: HorarioComponent},
    {path: "maestros", component: MaestrosComponent},
    {path: "tarifas", component: TarifasComponent},
    {path: "contacto", component: ContactoComponent},
    {path: "login", component:LoginComponent},
    {path: "register", component:RegisterComponent},
    {path: "maestro/:id", component:MaestroComponent},
    {path: "sesion/:id", component:SesionComponent},
    {path: "usuario/:id", component:UsuarioComponent},
    {path: "arteMarcial/:id", component:ArtemarcialComponent},
    { path: 'admin', component: AdminComponent, canActivate: [AdminAuthGuardComponent] }

];
export const appRouterProviders = provideRouter(routes);