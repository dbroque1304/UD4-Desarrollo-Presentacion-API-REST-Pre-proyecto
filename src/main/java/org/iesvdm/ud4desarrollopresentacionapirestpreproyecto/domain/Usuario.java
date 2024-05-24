package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

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
    private String apellido1;
    private String apellido2;
    private String telefono;

    @ManyToMany(mappedBy = "usuarios")
    private Set<Sesion> sesiones;
}
