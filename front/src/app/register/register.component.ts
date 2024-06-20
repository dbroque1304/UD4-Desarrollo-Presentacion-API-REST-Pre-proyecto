import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { AppService } from '../app.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, NgIf, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private appService: AppService, private router: Router) {
    this.form = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      nombreUsuario: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      telefono: ['', [Validators.required, Validators.pattern('[0-9]{9}')]],
      contraseña: ['', [Validators.required, this.passwordValidator]],
      confirmarContraseña: ['', Validators.required]
    }, {
      validators: this.passwordMatchValidator
    });
  }
  submit(){
    if (this.form.valid) {
      console.log('Formulario válido:', this.form.value);
      this.appService.createUsuario(this.form.value).subscribe(res => {
        console.log('Usuario creado correctamente', res);
        this.router.navigateByUrl('/login');
      });
    } else {
      console.error('Formulario inválido. Revisa los campos.');
    }
  }
  passwordValidator(control: AbstractControl): ValidationErrors | null {
    const value: string = control.value;
    const hasNumber = /\d/.test(value);
    const hasUpper = /[A-Z]/.test(value);
    const hasLower = /[a-z]/.test(value);
    const valid = hasNumber && hasUpper && hasLower;
    return valid ? null : { invalidPassword: true };
  }

  passwordMatchValidator(control: AbstractControl): ValidationErrors | null {
    const password = control.get('contraseña');
    const confirmPassword = control.get('confirmarContraseña');
    return password && confirmPassword && password.value === confirmPassword.value ? null : { passwordMismatch: true };
  }
}
