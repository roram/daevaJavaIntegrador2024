package ar.daeva.utn.entrega.models.entities;

import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime fechaHoraPartida;
    @Column
    private LocalDateTime fechaHoraLlegada;
    @OneToOne
    private CiudadesDistancia ruta;


}
