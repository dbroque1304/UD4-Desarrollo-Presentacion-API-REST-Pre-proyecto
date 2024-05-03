package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.hibernate.query.Page;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArteMarcialRepository extends JpaRepository<ArteMarcial, Integer> {
}
