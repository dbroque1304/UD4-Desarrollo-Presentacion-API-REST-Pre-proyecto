import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService, Maestro, Sesion } from '../../app.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-maestro',
  standalone: true,
  imports: [NgFor],
  templateUrl: './maestro.component.html',
  styleUrl: './maestro.component.scss'
})
export class MaestroComponent {
  maestro: Maestro = {
    id: 0,
    nombre: "",
    apellido1: "",
    apellido2: "",
    telefono: "",
    email: "",
    rango: "",
    sesiones: [],
    maestroArteMarcials: []

  };

  constructor(
    private route: ActivatedRoute,
    private appService: AppService,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.findSesionesByMaestro(+id);
      this.appService.getMaestroById(+id).subscribe((data) => {
        this.maestro = (data as any);
      });
    }
  }

  findSesionesByMaestro(id:number){
    this.appService.findSesionsByMaestro_Id(id).subscribe(res => {
      this.maestro.sesiones = res as Sesion[];
    })
  }
  goToArteMarcialDetail(id: number): void {
    this.router.navigate(['/arteMarcial', id]);
  }
  goToSesionDetail(id: number): void {
    this.router.navigate(['/sesion', id]);
  }
}
