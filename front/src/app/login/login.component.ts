import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppService } from '../app.service';
import { NgIf } from '@angular/common';
import { StorageService } from '../storage.service';
import { AdminAuthGuardComponent } from '../admin-auth-guard/admin-auth-guard.component';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, FormsModule, ReactiveFormsModule, NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  mensajeError:boolean = false;
  form: FormGroup = new FormGroup({
    nombreUsuario: new FormControl('',[]),
    contraseña: new FormControl('',[]),
  });
  constructor(private appService:AppService, private router:Router, private storageService:StorageService, private adminAuthGuard:AdminAuthGuardComponent){

  }
  login(){
    this.appService.login(this.form.value).subscribe(res => {
      if(res.estado == "OK"){
        this.storageService.saveUser(res);
        if(this.adminAuthGuard.canActivate()){
          this.router.navigateByUrl('/admin');
        }
        this.router.navigateByUrl('/');
      } else {
        this.mensajeError = true;
      }
    })
  }
}
