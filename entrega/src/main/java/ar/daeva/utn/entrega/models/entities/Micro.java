package ar.daeva.utn.entrega.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="micro")

public class Micro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String patente;
    @Column
    private Integer cant_asientos;
}
