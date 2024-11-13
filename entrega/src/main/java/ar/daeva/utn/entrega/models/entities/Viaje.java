package ar.daeva.utn.entrega.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "micro_id")
    private Micro micro;
    @Column
    private LocalDate fechaHoraPartida;
    @Column
    private LocalDate fechaHoraLlegada;
    @OneToOne
    private Ciudades ciudad;

    @Override
    public String toString(){
        return
                this.micro.toString() + " " +
                "Fecha Hora Partida: " + this.fechaHoraPartida.toString() + " " +
                "Fecha Hora de Llegada: " + this.fechaHoraLlegada.toString() + " " +
                "Distancia: " + this.ciudad;
    }

}
