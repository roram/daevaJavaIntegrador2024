package ar.daeva.utn.entrega.datos.input;

import lombok.Data;

@Data
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
