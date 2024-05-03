package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Horario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception.HorarioNotFoundException;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }


    public List<Horario> all() {
        return this.horarioRepository.findAll();
    }

    public Horario save(Horario horario) {
        return this.horarioRepository.save(horario);
    }

    public Horario one(Integer id) {
        return this.horarioRepository.findById(id)
                .orElseThrow(() -> new HorarioNotFoundException(id));
    }

    public Horario replace(Integer id, Horario horario) {
        return this.horarioRepository.findById(id).map(m -> (id.equals(horario.getId()) ?
                        this.horarioRepository.save(horario) : null))
                .orElseThrow(() -> new HorarioNotFoundException(id));
    }

    public void delete(Integer id) {
        this.horarioRepository.findById(id).map(m -> {
            this.horarioRepository.delete(m);
            return m;
        }).orElseThrow(() -> new HorarioNotFoundException(id));
    }
}
