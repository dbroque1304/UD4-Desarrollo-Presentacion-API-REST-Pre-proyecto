import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavContainerComponent } from './componentes/nav-container/nav-container.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavContainerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';
}
