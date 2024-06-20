package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.ResponseLogin;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Usuario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service.UsuarioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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
        usuario.setRol("user");
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

    @GetMapping("/findUsuariosByArteMarcial")
    public List<Usuario> findUsuariosBy_Id(@RequestParam int id){
        return this.usuarioService.fincUsuariosBy_Id(id);
    }
    @PostMapping("/login")
    public ResponseLogin usuarioLogin(@RequestBody Usuario usuario){
        Usuario usuarioBD = this.usuarioService.login(usuario);
        if(usuarioBD != null && usuarioBD.getContraseña().equals(usuario.getContraseña())){
            String originalInput = System.currentTimeMillis() + "#" + usuarioBD.getRol();
            String token = Base64.getEncoder().encodeToString(originalInput.getBytes());
            return new ResponseLogin("OK", token, usuarioBD.getRol(), usuarioBD.getId());
        } else {
            return new ResponseLogin("FAIL", null, null, null);
        }
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        String tokenPuro = token.replaceAll("Bearer ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(tokenPuro);
        String decodedString = new String(decodedBytes);
        String[] arrayTimeStampRol = decodedString.split("#");
        if(arrayTimeStampRol[1].equals("admin")){
            this.usuarioService.delete(id);
        }
    }

}
