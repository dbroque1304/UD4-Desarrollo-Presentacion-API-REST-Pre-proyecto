package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class UsuarioArteMarcial {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Embeddable
    public static class Pk implements Serializable {
        @ManyToOne
        @JoinColumn(name = "usuario_id")
        @EqualsAndHashCode.Include
        @JsonIgnore
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(name = "artemarcial_id")
        @EqualsAndHashCode.Include
        private ArteMarcial arteMarcial;

    }

    @EmbeddedId
    @EqualsAndHashCode.Include
    private UsuarioArteMarcial.Pk id;

    private String rango;
}
