package ar.daeva.utn.entrega.models.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
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

    // Se agregaron constructores por error de Hybernate: HHH000327
    public Micro(){}

    public Micro(Long id, String marca, String modelo, String patente, Integer cant_asientos){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.cant_asientos = cant_asientos;
    }

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
