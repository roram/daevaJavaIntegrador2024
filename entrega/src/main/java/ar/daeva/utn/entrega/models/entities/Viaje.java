package ar.daeva.utn.entrega.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Micro micro;
    @Column
    private LocalDateTime fechaHoraPartida;
    @Column
    private LocalDateTime fechaHoraLlegada;
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
