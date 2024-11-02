package ar.daeva.utn.entrega.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="micro")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="tipo_producto")
public class Micro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String patente;
    @Column
    private Integer cant_asientos;

    @Override
    public String toString(){
        return
                "ID: " + this.id + " " +
                "Marca: " + this.marca + " " +
                "Modelo: " + this.modelo + " " +
                "Patente: " + this.patente + " " +
                "Cantidad de asientos: " + this.cant_asientos;
    }
}
