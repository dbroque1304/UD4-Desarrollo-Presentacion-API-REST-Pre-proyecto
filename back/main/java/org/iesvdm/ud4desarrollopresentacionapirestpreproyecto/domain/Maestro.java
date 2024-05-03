package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "maestro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "telefono")
    private String telefono;

    @ManyToMany(mappedBy = "maestros")
    @ToString.Exclude
    @JsonIgnore
    private Set<Sesion> sesiones;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private Set<ArteMarcial> artesMarciales;

}
