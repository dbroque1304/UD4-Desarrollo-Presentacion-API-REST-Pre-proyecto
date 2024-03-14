package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MaestroCustomRepositoryImpl implements MaestroCustomRepository {

    @Autowired
    private EntityManager em;
    @Override
    public List<Maestro> findByNombreContainingIgnoreCaseOrderByNombre(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        StringBuilder queryBuider = new StringBuilder("SELECT M from Maestro M");
        if (buscarOptional.isPresent()) {
            queryBuider.append(" ").append("WHERE M.nombre like :nombre");
        }
        if (ordenarOptional.isPresent()) {
            if ("asc".equalsIgnoreCase(ordenarOptional.get())){
                queryBuider.append(" ").append("ORDER BY M.nombre ASC");
            } else if ("desc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuider.append(" ").append("ORDER BY M.nombre DESC");
            }
        }
        Query query = em.createQuery(queryBuider.toString());
        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }

        List<Maestro> maestroList = query.getResultList();

        return maestroList;
    }

}
