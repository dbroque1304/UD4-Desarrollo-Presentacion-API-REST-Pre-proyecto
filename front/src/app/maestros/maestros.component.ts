import { Component } from '@angular/core';
import { AppService, Maestro } from '../app.service';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-maestros',
  standalone: true,
  imports: [NgFor],
  templateUrl: './maestros.component.html',
  styleUrl: './maestros.component.scss'
})
export class MaestrosComponent {
  constructor(private appService:AppService, private router:Router){}
  maestrosList:Maestro[] = [];

  ngOnInit(): void {
    this.getMaestros();
  }

  getMaestros(){
    this.appService.getMaestros().subscribe((data) =>
      this.maestrosList=(data as any))
  }

  goToMaestroDetail(id: number): void {
    this.router.navigate(['/maestro', id]);
  }
  
}
