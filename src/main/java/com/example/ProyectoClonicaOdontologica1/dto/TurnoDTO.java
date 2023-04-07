package com.example.ProyectoClonicaOdontologica1.dto;

import com.example.ProyectoClonicaOdontologica1.model.Odontologo;
import com.example.ProyectoClonicaOdontologica1.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Long id;

    private Date fechaDeTurno;
    private Paciente paciente;
    private Odontologo odontologo;
    //private String hora;

}
