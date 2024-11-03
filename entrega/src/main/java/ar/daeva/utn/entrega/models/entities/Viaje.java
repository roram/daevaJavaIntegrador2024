package ar.daeva.utn.entrega.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "micro_id")
    private Micro micro;
    @Column
    private LocalDate fechaHoraPartida;
    @Column
    private LocalDate fechaHoraLlegada;
    @OneToOne
    private Ciudades ciudades;


    @Override
    public String toString(){
        return
                this.micro.toString() + " " +
                "Fecha Hora Partida: " + this.fechaHoraPartida.toString() + " " +
                "Fecha Hora de Llegada: " + this.fechaHoraLlegada.toString() + " " +
                "Distancia: " + this.ciudades;
    }

}
