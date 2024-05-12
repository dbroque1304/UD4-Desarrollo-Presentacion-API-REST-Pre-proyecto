import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCard, MatCardContent } from '@angular/material/card'

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [MatToolbarModule, MatCard, MatCardContent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

}
