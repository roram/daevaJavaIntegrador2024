package ar.daeva.utn.entrega.models.entities.ciudades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ciudadesDistancia")
public class CiudadesDistancia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private Ciudades ciudadOrigen;
  @OneToOne
  private Ciudades ciudadDestino;
  @Column
  private Integer distancia;

  @Override
  public String toString(){

    return  "ID: " + this.id + "\n" +
            "Ciudad Origen: " + this.ciudadOrigen + "\n" +
            "Ciudad Destino: " + this.ciudadDestino + "\n" +
            "Distancia: " + this.distancia + "\n";

  }
}
