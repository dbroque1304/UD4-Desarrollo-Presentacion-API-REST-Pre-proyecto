package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreUsuario;
    private String nombre;
    private String email;
    private String contraseña;
    private String apellidos;
    private String telefono;
    private String rol;

    @ManyToMany(mappedBy = "usuarios")
    @JsonIgnore
    private Set<Sesion> sesiones;

    @OneToMany(mappedBy = "id.usuario")
    private Set<UsuarioArteMarcial> usuarioArteMarcials;
}
