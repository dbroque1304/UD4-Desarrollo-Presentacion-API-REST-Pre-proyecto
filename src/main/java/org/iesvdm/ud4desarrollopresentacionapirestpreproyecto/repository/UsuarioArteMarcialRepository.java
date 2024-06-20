package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.MaestroArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Usuario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.UsuarioArteMarcial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioArteMarcialRepository extends JpaRepository <UsuarioArteMarcial, UsuarioArteMarcial.Pk> {

}
