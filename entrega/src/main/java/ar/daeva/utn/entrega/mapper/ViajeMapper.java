package ar.daeva.utn.entrega.mapper;


import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.models.entities.Viaje;
import org.mapstruct.factory.Mappers;

public interface ViajeMapper {

    // Se tiene que crear esta constante, sino no se puede utilizar
    ViajeMapper INSTANCE = Mappers.getMapper(ViajeMapper.class);

    // Creo la clase Micro utilizando la clase MicronInputDTO para guardarlo en la base de datos
    Viaje dtoToViaje(ViajeInput viajeInputDto);

    // Creo la clase MicroOutputDTO utilizanco la clase Micro para la respuesta
    ViajeOutput viajeToDtoOutput(Viaje viaje);
}
