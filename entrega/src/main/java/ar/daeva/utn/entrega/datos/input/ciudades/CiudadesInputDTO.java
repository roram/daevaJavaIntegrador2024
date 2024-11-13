package ar.daeva.utn.entrega.datos.input.ciudades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CiudadesInputDTO {
  private String ciudad;

  @Override
  public String toString(){
    return ciudad;
  }
}
