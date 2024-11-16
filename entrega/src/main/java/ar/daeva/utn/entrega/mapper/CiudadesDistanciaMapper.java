package ar.daeva.utn.entrega.mapper;

import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CiudadesDistanciaMapper {
  CiudadesDistanciaMapper INSTANCE = Mappers.getMapper(CiudadesDistanciaMapper.class);
  //TODO: Reimplementar, algo no esta bien ahí.
  //CiudadesDistancia dtoToCiudadesDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO);
  CiudadesDistanciaOutputDTO ciudadesDistanciaToDtoOutput(CiudadesDistancia ciudadesDistancia);

}
