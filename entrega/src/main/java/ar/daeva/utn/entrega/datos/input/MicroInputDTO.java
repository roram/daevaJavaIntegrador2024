package ar.daeva.utn.entrega.datos.input;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MicroInputDTO {

  private String marca;
  private String modelo;
  private String patente;
  private Integer cant_asientos;

  @Override
  public String toString(){
    return
            "Marca: " + this.marca + " " +
            "Modelo: " + this.modelo + " " +
            "Patente: " + this.patente + " " +
            "Cantidad de asientos: " + this.cant_asientos;
  }

}
