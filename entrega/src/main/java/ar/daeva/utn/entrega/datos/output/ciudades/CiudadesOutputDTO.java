package ar.daeva.utn.entrega.datos.output.ciudades;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CiudadesOutputDTO {
  private Long id;
  private String ciudad;
}
