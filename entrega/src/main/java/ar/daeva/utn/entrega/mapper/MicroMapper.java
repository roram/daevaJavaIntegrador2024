package ar.daeva.utn.entrega.mapper;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.models.entities.Micro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MicroMapper {

  MicroMapper INSTANCE = Mappers.getMapper(MicroMapper.class);

  Micro dtoToMicro(MicroInputDTO microInputDTO);
}
