import { Component } from '@angular/core';
import { AppService, ArteMarcial, Maestro, Sesion, Usuario } from '../../app.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-artemarcial',
  standalone: true,
  imports: [NgFor],
  templateUrl: './artemarcial.component.html',
  styleUrl: './artemarcial.component.scss'
})
export class ArtemarcialComponent {
  sesiones: Sesion[]  = [];
  usuarios: Usuario[] = [];
  maestros: Maestro[] = [];
  arteMarcial: ArteMarcial | undefined;

  constructor(private route: ActivatedRoute, private appService: AppService, private router:Router) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.findMaestrosByArteMarcial(id);
    this.findSesionsByArteMarcial(id);
    this.findUsuariosByArteMarcial(id);
    console.log(this.usuarios)
    this.appService.getArteMarcialById(id).subscribe(arteMarcial => {
      this.arteMarcial = arteMarcial as ArteMarcial;
    });
  }
  findSesionsByArteMarcial(id:number){
    this.appService.findSesionsByArteMarcial_Id(id).subscribe(res => {
      this.sesiones = res as Sesion[];
    })
  }
  findUsuariosByArteMarcial(id:number){
    this.appService.findUsuariosByArteMarcial_Id(id).subscribe(res => {
      this.usuarios = res as Usuario[];
    })
  }
  findMaestrosByArteMarcial(id:number){
    this.appService.findMaestrosByArteMarcial_Id(id).subscribe(res => {
      this.maestros = res as Maestro[];
    })
  }

  goToUsuarioDetail(id: number): void {
    this.router.navigate(['/usuario', id]);
  }
  goToMaestroDetail(id: number): void {
    this.router.navigate(['/maestro', id]);
  }
  goToSesionDetail(id: number): void {
    this.router.navigate(['/sesion', id]);
  }
}
