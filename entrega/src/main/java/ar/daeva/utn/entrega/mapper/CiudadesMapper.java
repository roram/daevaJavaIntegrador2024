package ar.daeva.utn.entrega.mapper;


import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesInputDTO;

import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.models.entities.Ciudades;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CiudadesMapper {
  CiudadesMapper INSTANCE = Mappers.getMapper(CiudadesMapper.class);

  Ciudades dtoToCiudades(CiudadesInputDTO ciudadesInputDTO);

  Ciudades dtoOutputToCiudades(CiudadesOutputDTO ciudadesOutputDTO);

  CiudadesOutputDTO ciudadesToDtoOutput(Ciudades ciudades);
}
