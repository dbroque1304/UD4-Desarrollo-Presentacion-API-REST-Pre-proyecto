import { Component } from '@angular/core';
import { AppService, ArteMarcial, Horario, Maestro, Sesion, Usuario } from '../app.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [NgFor],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent {
  usuarios: Usuario[] = [];
  maestros: Maestro[] = [];
  artesMarciales: ArteMarcial[] = [];
  sesiones: Sesion[] = [];
  horarios: Horario[] = [];

  constructor(private adminService: AppService) {}

  ngOnInit(): void {
    this.loadAllData();
  }

  loadAllData(): void {
    this.adminService.getUsuarios().subscribe((data) => this.usuarios = data as any);
    this.adminService.getMaestros().subscribe(data => this.maestros = data as any);
    this.adminService.getArtesMarciales().subscribe(data => this.artesMarciales = data as any);
    this.adminService.getSesiones().subscribe(data => this.sesiones = data as any);
    this.adminService.getHorarios().subscribe(data => this.horarios = data as any);
  }

  deleteUser(id: number): void {
    this.adminService.deleteUser(id).subscribe(() => this.loadAllData());
  }

  deleteMaestro(id: number): void {
    this.adminService.deleteMaestro(id).subscribe(() => this.loadAllData());
  }

  deleteArteMarcial(id: number): void {
    this.adminService.deleteArteMarcial(id).subscribe(() => this.loadAllData());
  }

  deleteSesion(id: number): void {
    this.adminService.deleteSesion(id).subscribe(() => this.loadAllData());
  }

  deleteHorario(id: number): void {
    this.adminService.deleteHorario(id).subscribe(() => this.loadAllData());
  }
}
