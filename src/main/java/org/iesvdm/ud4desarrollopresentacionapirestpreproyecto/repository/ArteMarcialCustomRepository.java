package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArteMarcialCustomRepository {
    List<ArteMarcial> findByNombreContainingIgnoreCaseOrderByNombre(Optional<String> buscarOptional, Optional<String> ordenarOptional);
}