import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarHomeComponent } from './components/navbar_home/navbar_home.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarHomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';
}
