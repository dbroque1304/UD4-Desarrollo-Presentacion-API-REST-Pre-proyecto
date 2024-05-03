package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ArteMarcialCustomRepositoryImpl implements ArteMarcialCustomRepository {

    @Autowired
    private EntityManager em;
    @Override
    public List<ArteMarcial> findByNombreContainingIgnoreCaseOrderByNombre(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        StringBuilder queryBuider = new StringBuilder("SELECT A from ArteMarcial A");
        if (buscarOptional.isPresent()) {
            queryBuider.append(" ").append("WHERE A.nombre LIKE :nombre");
        }
        if (ordenarOptional.isPresent()) {
            if ("asc".equalsIgnoreCase(ordenarOptional.get())){
                queryBuider.append(" ").append("ORDER BY A.nombre ASC");
            } else if ("desc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuider.append(" ").append("ORDER BY A.nombre DESC");
            }
        }
        Query query = em.createQuery(queryBuider.toString());
        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }

        List<ArteMarcial> arteMarcialList = query.getResultList();
        System.out.println(arteMarcialList.toString());

        return arteMarcialList;
    }


}
