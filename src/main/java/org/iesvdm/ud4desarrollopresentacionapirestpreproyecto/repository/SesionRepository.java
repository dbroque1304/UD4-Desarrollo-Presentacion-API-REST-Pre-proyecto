package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {

    public List<Sesion> findSesionsByArteMarcial_NombreIgnoreCaseOrderByHorarios_FechaAscHorarios_HoraInicioAsc(String arteMarcial);

}
