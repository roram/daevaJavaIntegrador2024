package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.mapper.CiudadesMapper;
import ar.daeva.utn.entrega.models.entities.ciudades.Ciudad;
import ar.daeva.utn.entrega.models.repositories.CiudadRepository;
import ar.daeva.utn.entrega.services.ICiudadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadesService implements ICiudadesService {

  @Autowired
  private CiudadRepository ciudadRepository;

  @Override
  public CiudadesOutputDTO crearCiudad(CiudadesInputDTO ciudadesInputDTO) {

    Ciudad nuevaCiudad = CiudadesMapper.INSTANCE.dtoToCiudades(ciudadesInputDTO);

    CiudadesOutputDTO ciudadesOutputDTO = CiudadesMapper.INSTANCE.ciudadesToDtoOutput(
            this.ciudadRepository.save(nuevaCiudad));

    return ciudadesOutputDTO;
  }

  @Override
  public CiudadesOutputDTO obtenerCiudad(CiudadesInputDTO ciudadesInputDTO) {
    return null;
  }

  @Override
  public CiudadesOutputDTO obtenerCiudadPorNombre(String ciudadBusqueda) throws ChangeSetPersister.NotFoundException {
    Optional<Ciudad> obtenerCiudad = Optional.ofNullable(this.ciudadRepository.findCiudadesByCiudad(ciudadBusqueda));

    if(obtenerCiudad.isEmpty()){
      return null;
    }

    CiudadesOutputDTO ciudadesOutputDTO = CiudadesMapper.INSTANCE.ciudadesToDtoOutput(
            obtenerCiudad.get());

    return ciudadesOutputDTO;
  }
}
