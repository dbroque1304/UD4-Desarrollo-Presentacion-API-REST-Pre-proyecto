import { Component } from '@angular/core';
import { EntidadesModule } from './entidades/entidades.module';
import { NavbarHomeComponent } from './componentes/navbar-home/navbar-home.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [EntidadesModule, NavbarHomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';
}
