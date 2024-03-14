package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception.ArteMarcialNotFoundException;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.ArteMarcialCustomRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.ArteMarcialRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.MaestroRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.SesionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArteMarcialService {

    private final ArteMarcialRepository arteMarcialRepository;

    private final SesionRepository sesionRepository;
    private final MaestroRepository maestroRepository;
    private final ArteMarcialCustomRepository arteMarcialCustomRepository;

    public ArteMarcialService(ArteMarcialRepository arteMarcialRepository, SesionRepository sesionRepository, MaestroRepository maestroRepository, ArteMarcialCustomRepository arteMarcialCustomRepository) {
        this.arteMarcialRepository = arteMarcialRepository;
        this.sesionRepository = sesionRepository;
        this.maestroRepository = maestroRepository;
        this.arteMarcialCustomRepository = arteMarcialCustomRepository;
    }

    public List<ArteMarcial> all() {
        return this.arteMarcialRepository.findAll();
    }
    public List<ArteMarcial> allByNombre(Optional<String> optBuscar, Optional<String> optOrdenar) {
        return this.arteMarcialCustomRepository.findByNombreContainingIgnoreCaseOrderByNombre(optBuscar, optOrdenar);
    }

    public ArteMarcial save(ArteMarcial arteMarcial) {
        return this.arteMarcialRepository.save(arteMarcial);
    }

    public ArteMarcial one(Integer id) {
        return this.arteMarcialRepository.findById(id)
                .orElseThrow(() -> new ArteMarcialNotFoundException(id));
    }

    public ArteMarcial replace(Integer id, ArteMarcial arteMarcial) {
        return this.arteMarcialRepository.findById(id).map(a -> (id.equals(arteMarcial.getId()) ?
                        this.arteMarcialRepository.save(arteMarcial) : null))
                .orElseThrow(() -> new ArteMarcialNotFoundException(id));
    }

    public void delete(Integer id) {
        this.arteMarcialRepository.findById(id).map(a -> {
            this.arteMarcialRepository.delete(a);
            return a;
        }).orElseThrow(() -> new ArteMarcialNotFoundException(id));
    }
}
