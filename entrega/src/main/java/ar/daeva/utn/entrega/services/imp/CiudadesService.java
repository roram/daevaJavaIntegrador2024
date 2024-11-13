package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.mapper.CiudadesMapper;
import ar.daeva.utn.entrega.models.entities.Ciudades;
import ar.daeva.utn.entrega.models.entities.CiudadesDistancia;
import ar.daeva.utn.entrega.models.repositories.CiudadesRepository;
import ar.daeva.utn.entrega.services.ICiudadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadesService implements ICiudadesService {

  @Autowired
  private CiudadesRepository ciudadesRepository;

  @Override
  public CiudadesOutputDTO crearCiudad(CiudadesInputDTO ciudadesInputDTO) {

    Ciudades nuevaCiudad = CiudadesMapper.INSTANCE.dtoToCiudades(ciudadesInputDTO);

    CiudadesOutputDTO ciudadesOutputDTO = CiudadesMapper.INSTANCE.ciudadesToDtoOutput(
            this.ciudadesRepository.save(nuevaCiudad));

    return ciudadesOutputDTO;
  }

  @Override
  public CiudadesOutputDTO obtenerCiudad(CiudadesInputDTO ciudadesInputDTO) {
    return null;
  }

  @Override
  public CiudadesOutputDTO obtenerCiudadPorNombre(String ciudadBusqueda) {
    Ciudades obtenerCiudad = this.ciudadesRepository.findCiudadesByCiudad(ciudadBusqueda);

    CiudadesOutputDTO ciudadesOutputDTO = CiudadesMapper.INSTANCE.ciudadesToDtoOutput(
            this.ciudadesRepository.save(obtenerCiudad));

    if(ciudadesOutputDTO == null){
      return null;
    }

    return ciudadesOutputDTO;
  }
}
