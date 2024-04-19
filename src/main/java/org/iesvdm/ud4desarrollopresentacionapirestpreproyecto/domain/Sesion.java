package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
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
    private Set<Horario> horarios;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private ArteMarcial arteMarcial;

    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private Set<Maestro> maestros;

    public Sesion(int id, String nombre, int num_plazas, boolean paraMayores, ArteMarcial arteMarcial, Set<Maestro> maestros) {
        this.id = id;
        this.nombre = nombre;
        this.num_plazas = num_plazas;
        this.paraMayores = paraMayores;
        this.arteMarcial = arteMarcial;
        this.maestros = maestros;
    }
}
