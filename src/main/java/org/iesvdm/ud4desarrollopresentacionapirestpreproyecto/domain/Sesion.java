package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Sesion")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "num_plazas")
    private int num_plazas;

    @Column(name = "paraMayores")
    private boolean paraMayores;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Horario> horarios = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    private ArteMarcial arteMarcial;

    @ManyToMany
    @ToString.Exclude
    private Set<Maestro> maestros  = new HashSet<>();

    public Sesion(int id, String nombre, int num_plazas, boolean paraMayores, ArteMarcial arteMarcial, Set<Maestro> maestros) {
        this.id = id;
        this.nombre = nombre;
        this.num_plazas = num_plazas;
        this.paraMayores = paraMayores;
        this.arteMarcial = arteMarcial;
        this.maestros = maestros;
    }
    @ManyToMany
    Set<Usuario> usuarios  = new HashSet<>();;

}
