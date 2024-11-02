package ar.daeva.utn.entrega.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ciudades")

public class Ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer kms;

    @Override
    public String toString(){
        return
                "Nombre ciudad: " + this.name + " " +
                "Distancia en KMS: " + this.kms + " ";
    }

}
