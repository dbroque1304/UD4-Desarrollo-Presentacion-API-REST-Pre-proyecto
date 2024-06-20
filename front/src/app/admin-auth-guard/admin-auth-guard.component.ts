import { Component } from '@angular/core';
import { StorageService } from '../storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-auth-guard',
  standalone: true,
  imports: [],
  templateUrl: './admin-auth-guard.component.html',
  styleUrl: './admin-auth-guard.component.scss'
})
export class AdminAuthGuardComponent {
  constructor(
    private storageService: StorageService,
    private router: Router
  ) {}

  canActivate(): boolean {
    const user = this.storageService.getUser();
    if (user && user.rol === 'admin') {
      return true;
    } else {
      this.router.navigateByUrl('/'); 
      return false;
    }
  }
}
