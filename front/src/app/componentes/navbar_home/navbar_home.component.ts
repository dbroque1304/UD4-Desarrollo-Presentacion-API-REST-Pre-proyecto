import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCard, MatCardContent } from '@angular/material/card'
import { RouterLink, RouterLinkActive } from '@angular/router';


@Component({
  selector: 'app-navbar-home',
  standalone: true,
  imports: [MatToolbarModule, MatCard, MatCardContent, RouterLink, RouterLinkActive],
  templateUrl: './navbar_home.component.html',
  styleUrl: './navbar_home.component.scss'
})
export class NavbarHomeComponent {

}
