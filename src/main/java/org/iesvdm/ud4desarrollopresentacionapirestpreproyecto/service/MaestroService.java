package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception.MaestroNotFoundException;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.MaestroCustomRepository;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroService {
    private final MaestroRepository maestroRepository;
    private final MaestroCustomRepository maestroCustomRepository;


    public MaestroService(MaestroRepository maestroRepository, MaestroCustomRepository maestroCustomRepository) {
        this.maestroRepository = maestroRepository;
        this.maestroCustomRepository = maestroCustomRepository;
    }

    public List<Maestro> all() {
        return this.maestroRepository.findAll();
    }
    public List<Maestro> allByNombre(Optional<String> optBuscar, Optional<String> optOrdenar) {
        return this.maestroCustomRepository.findByNombreContainingIgnoreCaseOrderByNombre(optBuscar, optOrdenar);
    }

    public List<Maestro> findMaestrosBy_Id(int id){
        return this.maestroRepository.findMaestrosById(id);
    }
    public Maestro save(Maestro maestro) {
        return this.maestroRepository.save(maestro);
    }

    public Maestro one(Integer id) {
        return this.maestroRepository.findById(id)
                .orElseThrow(() -> new MaestroNotFoundException(id));
    }

    public Maestro replace(Integer id, Maestro maestro) {
        return this.maestroRepository.findById(id).map(m -> (id.equals(maestro.getId()) ?
                        this.maestroRepository.save(maestro) : null))
                .orElseThrow(() -> new MaestroNotFoundException(id));
    }

    public void delete(Integer id) {
        this.maestroRepository.findById(id).map(m -> {
            this.maestroRepository.delete(m);
            return m;
        }).orElseThrow(() -> new MaestroNotFoundException(id));
    }
}
