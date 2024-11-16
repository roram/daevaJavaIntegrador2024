package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface ICiudadesService {
  CiudadesOutputDTO crearCiudad(CiudadesInputDTO ciudadesInputDTO);
  CiudadesOutputDTO obtenerCiudad(CiudadesInputDTO ciudadesInputDTO);
  CiudadesOutputDTO obtenerCiudadPorNombre(String ciudad) throws ChangeSetPersister.NotFoundException;
}
