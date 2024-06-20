package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.repository;

import org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findUsuarioByNombreUsuario(String nombreUsuario);

    public List<Usuario> findUsuariosById(int id);
}
