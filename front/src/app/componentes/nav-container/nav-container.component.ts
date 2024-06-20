import { Component } from '@angular/core';
import { NavbarHomeComponent } from '../navbar_home/navbar_home.component';
import { NgIf } from '@angular/common';
import { NavComponent } from '../nav/nav.component';
import { Router, NavigationEnd } from '@angular/router';


@Component({
  selector: 'app-nav-container',
  standalone: true,
  imports: [NgIf, NavbarHomeComponent, NavComponent],
  templateUrl: './nav-container.component.html',
  styleUrl: './nav-container.component.scss'
})
export class NavContainerComponent {
  isHome: boolean = false;
  isLogin: boolean = false;

  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.isHome = event.url === '/';
        this.isLogin = event.url === '/login' || event.url === '/register';
      }
    });
  }
}
