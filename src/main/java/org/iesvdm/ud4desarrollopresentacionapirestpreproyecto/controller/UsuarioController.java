package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Usuario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){this.usuarioService = usuarioService;
    }

    @GetMapping(value = {"","/"})
    public List<Usuario> all() {
        log.info("Accediendo a todas las Artes Marciales");
        return this.usuarioService.all();
    }

    @PostMapping({"","/"})
    public Usuario newUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario one(@PathVariable("id") Integer id) {
        return this.usuarioService.one(id);
    }

    @PutMapping("/{id}")
    public Usuario replaceUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        return this.usuarioService.replace(id, usuario);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id) {
        this.usuarioService.delete(id);
    }

}
