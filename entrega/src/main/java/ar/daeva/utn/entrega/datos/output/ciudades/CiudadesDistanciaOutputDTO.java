package ar.daeva.utn.entrega.datos.output.ciudades;

import ar.daeva.utn.entrega.models.entities.Ciudades;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CiudadesDistanciaOutputDTO {
  private Ciudades ciudadOrigen;
  private Ciudades ciudadDestino;
  private Integer distancia;
}
