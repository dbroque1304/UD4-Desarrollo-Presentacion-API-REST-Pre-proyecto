package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaestroRepository extends JpaRepository<Maestro, Integer> {
    public List<Maestro> findMaestrosById(int id);

}
