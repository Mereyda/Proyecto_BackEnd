package com.example.ProyectoClonicaOdontologica1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Domicilios")
public class Domicilio  {
    @Id
    @SequenceGenerator(name="domicilio_sequence", sequenceName = "domicilio_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties({"hiberateLazyInitializer","handler"}) //agregue estas entencia
    private Paciente paciente;

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
