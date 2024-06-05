import { Time } from "@angular/common"

export interface Maestro{
    id: number,
    nombre: string,
    apellido1: string,
    apellido2: string,
    telefono: string,
    sesiones: Sesion[],
    artesMarciales: ArteMarcial[]
}
export interface ArteMarcial {
    id: number,
    nombre: string,
    sesiones: Sesion[],
    maestros: Maestro[]
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
    horaInicio: Time,
    horaFin: Time,
    fecha: Time
}

export interface Usuario {
    id: number,
    nombreUsuario: string,
    nombre: string,
    apellido1: string,
    apellido2: string,
    telefono: string,
    sesiones: Sesion[]
}