package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;

import java.util.List;
import java.util.Optional;

public interface MaestroCustomRepository {
    List<Maestro> findByNombreContainingIgnoreCaseOrderByNombre(Optional<String> buscarOptional, Optional<String> ordenarOptional);
}