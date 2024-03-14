package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.MaestroService;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/maestro")
public class MaestroController {
    private final MaestroService maestroService;
    public MaestroController(MaestroService maestroService){this.maestroService = maestroService;}

    @GetMapping(value = {"","/"}, params = {"!nombre", "!ordenar"})
    public List<Maestro> all() {
        log.info("Accediendo a todos los maestros");
        return this.maestroService.all();
    }
    @GetMapping({"","/"})
    public List<Maestro> allByNombre(@RequestParam("nombre") Optional<String> optBuscar
            , @RequestParam("ordenar")Optional<String> optOrdenar) {

        log.info("Accediendo a todos los Maestros");
        return this.maestroService.allByNombre(optBuscar,optOrdenar);
    }

    @PostMapping({"","/"})
    public Maestro newMaestro(@RequestBody Maestro maestro) {
        return this.maestroService.save(maestro);
    }

    @GetMapping("/{id}")
    public Maestro one(@PathVariable("id") Integer id) {
        return this.maestroService.one(id);
    }

    @PutMapping("/{id}")
    public Maestro replaceMaestro(@PathVariable("id") Integer id, @RequestBody Maestro maestro) {
        return this.maestroService.replace(id, maestro);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMaestro(@PathVariable("id") Integer id) {
        this.maestroService.delete(id);
    }

}
