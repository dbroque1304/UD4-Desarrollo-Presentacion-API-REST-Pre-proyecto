import { Time } from "@angular/common"
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
  const ARTESMARCIALESURL = "http://localhost:8080/v1/api/arteMarcial";
  const HORARIOSURL = "http://localhost:8080/v1/api/horario";
  const MAESTROSURL = "http://localhost:8080/v1/api/maestros";
  const SESIONESURL = "http://localhost:8080/v1/api/sesion";
  const USUARIOSURL = "http://localhost:8080/v1/api/usuario";
  const LOGINUSUARIOURL = "http://localhost:8080/v1/api/usuario/login";
  const AM_BUSCARNOMBREURL = "http://localhost:8080/v1/api/arteMarcial?nombre="
  
  
  const HTTPOPTIONS = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
  @Injectable({
    providedIn: 'root'
  })
  export class AppService {
    
    constructor(private http:HttpClient){}

    getArtesMarciales():Observable<Object>{
        return this.http.get(ARTESMARCIALESURL, HTTPOPTIONS);
    }
    getArteMarcialByNombre(nombre:String):Observable<Object>{
        return this.http.get(AM_BUSCARNOMBREURL + nombre, HTTPOPTIONS);
    }
    getHorarios():Observable<Object>{
        return this.http.get(HORARIOSURL, HTTPOPTIONS);
    }
    getSesiones():Observable<Sesion[]>{
        return this.http.get<Sesion[]>(SESIONESURL, HTTPOPTIONS);
    }
    getUsuarios():Observable<Object>{
        return this.http.get(USUARIOSURL, HTTPOPTIONS);
    }
    getMaestros():Observable<Object>{
        return this.http.get(MAESTROSURL, HTTPOPTIONS);
    }
    getMaestroById(id:number):Observable<Object>{
      return this.http.get(MAESTROSURL + "/"+id, HTTPOPTIONS);
    }
    getSesionById(id:number):Observable<Object>{
      return this.http.get(SESIONESURL + "/"+id, HTTPOPTIONS);
    }
    getArteMarcialById(id:number){
      return this.http.get(ARTESMARCIALESURL + "/" + id, HTTPOPTIONS);
    }
    getUsuarioById(id:number):Observable<Usuario>{
      return this.http.get<Usuario>(USUARIOSURL + "/" +id, HTTPOPTIONS);
    }

    findSesionsByMaestro_Id(id:number):Observable<Object>{
      return this.http.get(SESIONESURL + "/findSesionsByMaestro?id=" + id, HTTPOPTIONS);
    }

    findSesionsByUsuario_Id(id:number):Observable<Object>{
      return this.http.get(SESIONESURL + "/findSesionsByUsuario?id=" + id, HTTPOPTIONS);
    }
    findSesionsByArteMarcial_Id(id:number){
      return  this.http.get(SESIONESURL + "/findSesionsByArteMarcial?id=" + id, HTTPOPTIONS);
    }
    findUsuariosByArteMarcial_Id(id:number){
      return this.http.get(USUARIOSURL + "/findUsuariosByArteMarcial?id=" + id, HTTPOPTIONS);
    }
    findMaestrosByArteMarcial_Id(id:number){
      return this.http.get(MAESTROSURL + "/findMaestrosByArteMarcial?id=" + id, HTTPOPTIONS)
    }
    createUsuario(usuario: Usuario):Observable<Usuario>{
      return this.http.post<Usuario>(USUARIOSURL, JSON.stringify(usuario), HTTPOPTIONS)
    }
    

    login(usuario:Usuario){
      return this.http.post<RespLogin>(LOGINUSUARIOURL, JSON.stringify(usuario), HTTPOPTIONS);
    }
    updateUser(user: Usuario): Observable<any> {
      return this.http.put<any>(USUARIOSURL + "/" + user.id, user); 
    }

    deleteUser(id: number): Observable<void> {
      return this.http.delete<void>(USUARIOSURL + "/" + id);
    }
    deleteMaestro(id: number): Observable<void> {
      return this.http.delete<void>(MAESTROSURL + "/" + id);
    }
    deleteArteMarcial(id: number): Observable<void> {
      return this.http.delete<void>(ARTESMARCIALESURL + "/" + id);
    }
    deleteSesion(id: number): Observable<void> {
      return this.http.delete<void>(SESIONESURL + "/" + id);
    }
    deleteHorario(id: number): Observable<void> {
      return this.http.delete<void>(HORARIOSURL + "/" + id);
    }
  }

export interface Maestro{
    id: number,
    nombre: string,
    apellido1: string,
    apellido2: string,
    telefono: string,
    email: string,
    rango: string,
    sesiones: Sesion[],
    maestroArteMarcials: MaestroArtesMarciales[],
}
export interface Pk {
  maestro:Maestro;
  arteMarcial:ArteMarcial;
}
export interface PkUsuario {
  usuario:Usuario;
  arteMarcial:ArteMarcial;
}
export interface MaestroArtesMarciales{
  id:Pk;
  rango:string;
}
export interface UsuarioArtesMarciales{
  id:PkUsuario;
  rango:string;
}
export interface ArteMarcial {
    id: number,
    nombre: string,
    sesiones: Sesion[],
    maestroArteMarcials: MaestroArtesMarciales[],
    usuarioArtesMarcials:UsuarioArtesMarciales[]
}
export interface Sesion {
    id:number,
    nombre: string,
    num_plazas: number,
    paraMayores: boolean,
    horarios: Horario[],
    arteMarcial:ArteMarcial,
    maestros:Maestro[],
    usuarios:Usuario[]
}

export interface Horario {
    id: number,
    dia: number,
    horaInicio: String,
    horaFin: String,
    fecha: Time
}

export interface Usuario {
    id: number,
    nombreUsuario: string,
    nombre: string,
    email: string,
    contraseña: string,
    apellidos:string,
    telefono: string,
    rol:string,
    sesiones: Sesion[],
    usuarioArteMarcials: UsuarioArtesMarciales[]
}
export interface RespLogin {
  estado:string,
  token:string,
  rol:string,
  id:number
}