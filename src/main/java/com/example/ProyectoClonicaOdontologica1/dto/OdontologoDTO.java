package com.example.ProyectoClonicaOdontologica1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;

}
