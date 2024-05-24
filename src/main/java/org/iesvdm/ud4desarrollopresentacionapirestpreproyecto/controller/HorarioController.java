package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Horario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/horario")
public class HorarioController {
    private final HorarioService horarioService;
    public HorarioController(HorarioService horarioService){this.horarioService = horarioService;
    }

    @GetMapping(value = {"","/"})
    public List<Horario> all() {
        log.info("Accediendo a todas las Artes Marciales");
        return this.horarioService.all();
    }

    @PostMapping({"","/"})
    public Horario newHorario(@RequestBody Horario horario) {
        return this.horarioService.save(horario);
    }

    @GetMapping("/{id}")
    public Horario one(@PathVariable("id") Integer id) {
        return this.horarioService.one(id);
    }

    @PutMapping("/{id}")
    public Horario replaceHorario(@PathVariable("id") Integer id, @RequestBody Horario horario) {
        return this.horarioService.replace(id, horario);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable("id") Integer id) {
        this.horarioService.delete(id);
    }

}
