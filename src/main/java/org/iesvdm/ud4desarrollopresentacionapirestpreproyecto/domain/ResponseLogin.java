package org.iesvdm.ud4desarrollopresentacionapirestpreproyecto.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseLogin {
    private String estado;
    private  String token;
    private String rol;
    private Integer id;

}
