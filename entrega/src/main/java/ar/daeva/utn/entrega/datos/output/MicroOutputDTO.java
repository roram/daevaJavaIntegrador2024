package ar.daeva.utn.entrega.datos.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MicroOutputDTO {
  private Long id;
  private String marca;
  private String modelo;
  private String patente;
  private Integer cant_asientos;
}
