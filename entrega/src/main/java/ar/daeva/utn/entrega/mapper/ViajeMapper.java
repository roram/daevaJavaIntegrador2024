package ar.daeva.utn.entrega.mapper;


import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.entities.Viaje;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ViajeMapper {

    // Se tiene que crear esta constante, sino no se puede utilizar
    ViajeMapper INSTANCE = Mappers.getMapper(ViajeMapper.class);

    // Creo la clase Viaje utilizando la clase ViajeInput para guardarlo en la base de datos
    Viaje dtoToViaje(ViajeInput viajeInputDto);

    // Creo la clase ViajeOutput utilizanco la clase Viaje para la respuesta
    ViajeOutput viajeToDtoOutput(Viaje viaje);

    void update(@MappingTarget Viaje viaje, ViajeInput viajeInput);
}
