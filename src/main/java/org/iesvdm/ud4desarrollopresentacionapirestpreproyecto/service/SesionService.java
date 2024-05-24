package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception.SesionNotFoundException;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.SesionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SesionService {

    private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }


    public List<Sesion> all() {
        return this.sesionRepository.findAll();
    }

    public Map<String, Object> all(int pagina, int tamanio) {

        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());
        Page<Sesion> sesionPage = this.sesionRepository.findAll(paginado);
        Map<String, Object> response = new HashMap<>();
        response.put("sesiones", sesionPage.getContent());
        response.put("currentPage", sesionPage.getNumber());
        response.put("totalItems", sesionPage.getTotalElements());
        response.put("totalPages", sesionPage.getTotalPages());
        return response;
    }

    public Sesion save(Sesion sesion) {
        return this.sesionRepository.save(sesion);
    }

    public Sesion one(Integer id) {
        return this.sesionRepository.findById(id)
                .orElseThrow(() -> new SesionNotFoundException(id));
    }

    public Sesion replace(Integer id, Sesion sesion) {
        return this.sesionRepository.findById(id).map(s -> (id.equals(sesion.getId()) ?
                        this.sesionRepository.save(sesion) : null))
                .orElseThrow(() -> new SesionNotFoundException(id));
    }

    public void delete(Integer id) {
        this.sesionRepository.findById(id).map(s -> {
            this.sesionRepository.delete(s);
            return s;
        }).orElseThrow(() -> new SesionNotFoundException(id));
    }
}