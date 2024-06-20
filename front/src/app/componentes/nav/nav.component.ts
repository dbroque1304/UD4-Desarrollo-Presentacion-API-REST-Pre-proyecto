import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { StorageService } from '../../storage.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [MatButtonModule, MatToolbarModule, RouterLink, RouterLinkActive, NgIf],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.scss'
})
export class NavComponent {
  mostrarBotonCerrarSesion: boolean = false;
  constructor(private router: Router, public storageService: StorageService) { }

  loginOrProfile() {
    if (this.storageService.isLoggedIn()) {
      this.mostrarBotonCerrarSesion = true;
      const user = this.storageService.getUser();
      const userId = user.id;
      if (user.id) {
        this.router.navigateByUrl(`/usuario/` + +userId);
      } else {
        console.error('User ID is missing in storage');
      }
    } else {
      this.router.navigateByUrl('/login');
    }
  }
  logOut() {
    this.storageService.logOut();
    this.router.navigateByUrl('/login');
  }
}
