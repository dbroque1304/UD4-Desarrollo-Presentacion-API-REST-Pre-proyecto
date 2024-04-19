package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.service;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Usuario;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.exception.UsuarioNotFoundException;
import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> all() {
        return this.usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario one(Integer id) {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario replace(Integer id, Usuario usuario) {
        return this.usuarioRepository.findById(id).map(m -> (id.equals(usuario.getId()) ?
                        this.usuarioRepository.save(usuario) : null))
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public void delete(Integer id) {
        this.usuarioRepository.findById(id).map(m -> {
            this.usuarioRepository.delete(m);
            return m;
        }).orElseThrow(() -> new UsuarioNotFoundException(id));
    }
}
