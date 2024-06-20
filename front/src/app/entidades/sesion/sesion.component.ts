import { Component } from '@angular/core';
import { AppService, ArteMarcial, Sesion } from '../../app.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgClass, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-sesion',
  standalone: true,
  imports: [NgIf, NgClass, NgFor],
  templateUrl: './sesion.component.html',
  styleUrl: './sesion.component.scss'
})
export class SesionComponent {
  sesion: Sesion | undefined;
  arteMarcial: ArteMarcial | undefined;
  constructor(private route: ActivatedRoute, private sesionService: AppService, private router:Router) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.sesionService.getSesionById(id).subscribe(sesion => {
      this.sesion = sesion as Sesion;
    });
  }
  goToUsuarioDetail(id: number): void {
    this.router.navigate(['/usuario', id]);
  }
  goToMaestroDetail(id: number): void {
    this.router.navigate(['/maestro', id]);
  }
  goToArteMarcialDetail(id: number): void {
    this.router.navigate(['/arteMarcial', id]);
  }
}
