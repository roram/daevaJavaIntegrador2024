package ar.daeva.utn.entrega.mapper;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.models.entities.Ciudades;
import ar.daeva.utn.entrega.models.entities.CiudadesDistancia;
import ar.daeva.utn.entrega.models.entities.Viaje;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CiudadesDistanciaMapper {
  CiudadesDistanciaMapper INSTANCE = Mappers.getMapper(CiudadesDistanciaMapper.class);
  //TODO: Reimplementar, algo no esta bien ahí.
  //CiudadesDistancia dtoToCiudadesDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO);
  CiudadesDistanciaOutputDTO ciudadesDistanciaToDtoOutput(CiudadesDistancia ciudadesDistancia);

}
