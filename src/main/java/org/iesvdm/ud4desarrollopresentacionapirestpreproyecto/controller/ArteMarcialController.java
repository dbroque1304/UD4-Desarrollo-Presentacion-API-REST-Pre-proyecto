package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ArteMarcial;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Maestro;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.ArteMarcialService;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.MaestroService;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.SesionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/arteMarcial")
public class ArteMarcialController {
    private final ArteMarcialService arteMarcialService;
    public ArteMarcialController(ArteMarcialService arteMarcialService){this.arteMarcialService = arteMarcialService;
    }

    @GetMapping(value = {"","/"}, params = {"!nombre", "!ordenar"})
    public List<ArteMarcial> all() {
        log.info("Accediendo a todas las Artes Marciales");
        return this.arteMarcialService.all();
    }
    @GetMapping(value = {"","/"})
    public List<ArteMarcial> allByNombre(@RequestParam("nombre") Optional<String> optBuscar
            , @RequestParam("ordenar") Optional<String> optOrdenar) {

        log.info("Accediendo a todas las Artes Marciales");
        return this.arteMarcialService.allByNombre(optBuscar, optOrdenar);
    }

    @PostMapping({"","/"})
    public ArteMarcial newArteMarcial(@RequestBody ArteMarcial arteMarcial) {
        return this.arteMarcialService.save(arteMarcial);
    }

    @GetMapping("/{id}")
    public ArteMarcial one(@PathVariable("id") Integer id) {
        return this.arteMarcialService.one(id);
    }

    @PutMapping("/{id}")
    public ArteMarcial replaceArteMarcial(@PathVariable("id") Integer id, @RequestBody ArteMarcial arteMarcial) {
        return this.arteMarcialService.replace(id, arteMarcial);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteArteMarcial(@PathVariable("id") Integer id) {
        this.arteMarcialService.delete(id);
    }

}
