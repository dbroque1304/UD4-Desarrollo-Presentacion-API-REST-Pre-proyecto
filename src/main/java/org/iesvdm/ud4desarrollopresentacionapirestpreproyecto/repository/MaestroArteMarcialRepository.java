package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.MaestroArteMarcial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaestroArteMarcialRepository extends JpaRepository <MaestroArteMarcial, MaestroArteMarcial.Pk> {
}
