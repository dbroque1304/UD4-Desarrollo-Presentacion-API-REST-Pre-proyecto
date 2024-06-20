import { NgClass, NgFor, NgIf, Time } from '@angular/common';
import { Component } from '@angular/core';
import { NgModel } from '@angular/forms';
import { AppService, Horario, Sesion } from '../../app.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-horario',
  standalone: true,
  imports: [NgClass, RouterLink, NgIf, NgFor],
  templateUrl: './horario.component.html',
  styleUrl: './horario.component.scss'
})
export class HorarioComponent {
  sesiones: Sesion[] = [];

  constructor(private appService: AppService, private router: Router) { }

  ngOnInit(): void {
    this.getSesiones();
  }

  getSesiones(): void {
    this.appService.getSesiones()
      .subscribe(sesiones => this.sesiones = sesiones);
  }

  getSesionesPorHora(dia: number, horaInicio: string, horaFin: string): Sesion[] {
    return this.sesiones.filter(sesion =>
      sesion.horarios.some(horario =>
        horario.dia === dia &&
        horario.horaInicio === horaInicio &&
        horario.horaFin === horaFin
      )
    );
  }
  goToSesionDetail(id: number): void {
    this.router.navigate(['/sesion', id]);
  }
  
}

