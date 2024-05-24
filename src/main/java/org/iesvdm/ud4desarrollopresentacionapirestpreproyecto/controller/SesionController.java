package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Sesion;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/sesion")
public class SesionController {
    private final SesionService sesionService;
    public SesionController(SesionService sesionService){this.sesionService = sesionService;}

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio"})
    public List<Sesion> all() {
        log.info("Accediendo a todas las Sesiones");
        return this.sesionService.all();
    }
    @GetMapping(value = {"","/"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam("tamanio") int tamanio
            , @RequestParam("pagina")int pagina) {

        log.info("Accediendo a todas las Sesiones");
        Map<String, Object> response = this.sesionService.all(pagina, tamanio);
        return ResponseEntity.ok(response);
    }

    @PostMapping({"","/"})
    public Sesion newSesion(@RequestBody Sesion sesion) {
        return this.sesionService.save(sesion);
    }

    @GetMapping("/{id}")
    public Sesion one(@PathVariable("id") Integer id) {
        return this.sesionService.one(id);
    }

    @PutMapping("/{id}")
    public Sesion replaceSesion(@PathVariable("id") Integer id, @RequestBody Sesion sesion) {
        return this.sesionService.replace(id, sesion);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteSesion(@PathVariable("id") Integer id) {
        this.sesionService.delete(id);
    }

}
