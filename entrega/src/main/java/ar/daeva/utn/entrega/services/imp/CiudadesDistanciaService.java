package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.mapper.CiudadesDistanciaMapper;
import ar.daeva.utn.entrega.mapper.CiudadesMapper;
import ar.daeva.utn.entrega.models.entities.ciudades.Ciudad;
import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.models.repositories.ciudadesDistancia.CiudadesDistanciaRepository;
import ar.daeva.utn.entrega.services.ICiudadesDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadesDistanciaService implements ICiudadesDistanciaService {

  @Autowired
  CiudadesDistanciaRepository ciudadesDistanciaRepository;
  @Autowired
  CiudadesService ciudadesService;

  @Override
  public CiudadesDistanciaOutputDTO nuevaCiudadDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO) throws ChangeSetPersister.NotFoundException {

    CiudadesOutputDTO ciudadOrigenDTO = this.ciudadesService.obtenerCiudadPorNombre(ciudadesDistanciaInputDTO.getCiudadOrigen());
    CiudadesOutputDTO ciudadDestinoDTO =this.ciudadesService.obtenerCiudadPorNombre(ciudadesDistanciaInputDTO.getCiudadDestino());

    if(ciudadOrigenDTO == null || ciudadDestinoDTO == null){
      return null;
    }

    Ciudad ciudadOrigen = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadOrigenDTO);
    Ciudad ciudadDestino = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadDestinoDTO);

    CiudadesDistancia nuevaDistancia = new CiudadesDistancia();

    //TODO: Crear un mapper para actualizar nueva ruta.
    nuevaDistancia.setCiudadOrigen(ciudadOrigen);
    nuevaDistancia.setCiudadDestino(ciudadDestino);
    nuevaDistancia.setDistancia(ciudadesDistanciaInputDTO.getDistancia());

    CiudadesDistanciaOutputDTO nuevaDistanciaDTO = CiudadesDistanciaMapper.INSTANCE.ciudadesDistanciaToDtoOutput(this.ciudadesDistanciaRepository.save(nuevaDistancia));

    return nuevaDistanciaDTO;
  }

  @Override
  public RutaOutputDTO busquedaCiudadDistancia(String ciudadOrigenParam, String ciudadDestinoParam) throws ChangeSetPersister.NotFoundException {

    Optional<CiudadesOutputDTO> ciudadOrigenDTO = Optional.ofNullable(this.ciudadesService.obtenerCiudadPorNombre(ciudadOrigenParam));
    Optional<CiudadesOutputDTO> ciudadDestinoDTO = Optional.ofNullable(this.ciudadesService.obtenerCiudadPorNombre(ciudadDestinoParam));

    if(ciudadOrigenDTO.isEmpty() || ciudadDestinoDTO.isEmpty()){
      return null;
    }

    Ciudad ciudadOrigen = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadOrigenDTO.get());
    Ciudad ciudadDestino = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadDestinoDTO.get());

    Optional<RutaOutputDTO> rutaOutputDTO = Optional.ofNullable(ciudadesDistanciaRepository
            .findByCiudadOrigenAndCiudadDestino(ciudadOrigen.getId(), ciudadDestino.getId()));

    if(rutaOutputDTO.isEmpty()){
      return null;
    }

    return rutaOutputDTO.get();
  }
}
