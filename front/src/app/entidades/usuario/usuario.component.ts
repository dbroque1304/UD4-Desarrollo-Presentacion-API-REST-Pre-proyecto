import { Component } from '@angular/core';
import { AppService, Sesion, Usuario } from '../../app.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.scss'
})
export class UsuarioComponent {
  usuario: Usuario = {
    id:0,
    nombreUsuario:"",
    nombre:"",
    email:"",
    contraseña:"",
    apellidos:"",
    telefono:"",
    rol:"",
    sesiones:[],
    usuarioArteMarcials:[],
  }
  constructor(
    private route: ActivatedRoute,
    private appService: AppService,
    private router: Router
  ) {}

  ngOnInit(){
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      
      this.findSesionsByUsuario(+id);
      this.appService.getUsuarioById(+id).subscribe(data => {
        this.usuario = (data as any);
        console.log(this.usuario)
      })
    }
  }
  findSesionsByUsuario(id:number){
    this.appService.findSesionsByUsuario_Id(id).subscribe(res => {
      this.usuario.sesiones = res as Sesion[];
    })
  }
  goToSesionDetail(id: number): void {
    this.router.navigate(['/sesion', id]);
  }
  goToArteMarcialDetail(id: number): void {
    this.router.navigate(['/arteMarcial', id]);
  }
}
