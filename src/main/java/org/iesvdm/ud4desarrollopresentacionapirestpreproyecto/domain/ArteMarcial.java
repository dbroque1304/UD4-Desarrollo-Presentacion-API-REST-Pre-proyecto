package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ArteMarcial")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArteMarcial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "arteMarcial", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Sesion> sesiones;

    @JsonIgnore
    @OneToMany(mappedBy = "id.arteMarcial")
    private Set<MaestroArteMarcial> maestroArteMarcials;

    @JsonIgnore
    @OneToMany(mappedBy = "id.arteMarcial")
    private Set<UsuarioArteMarcial> usuarioArteMarcials;
}
