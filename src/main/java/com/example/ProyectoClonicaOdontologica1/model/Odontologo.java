package com.example.ProyectoClonicaOdontologica1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Odontologos")
public class Odontologo implements Serializable {
    @Id
    @SequenceGenerator(name="odontologo_sequence", sequenceName = "odontologo_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")


    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
