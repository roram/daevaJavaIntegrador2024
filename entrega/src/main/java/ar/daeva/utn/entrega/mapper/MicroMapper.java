package ar.daeva.utn.entrega.mapper;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.models.entities.Micro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MicroMapper {

  // Se tiene que crear esta constante, sino no se puede utilizar
  MicroMapper INSTANCE = Mappers.getMapper(MicroMapper.class);

  // Creo la clase Micro utilizando la clase MicronInputDTO para guardarlo en la base de datos
  Micro dtoToMicro(MicroInputDTO microInputDTO);

  // Creo la clase MicroOutputDTO utilizanco la clase Micro para la respuesta
  MicroOutputDTO microToDtoOutput(Micro micro);

  // Actualizo el objeto para guardarlo con sus nuevos datos
  void update(@MappingTarget Micro micro, MicroInputDTO microInputDTO);
}
