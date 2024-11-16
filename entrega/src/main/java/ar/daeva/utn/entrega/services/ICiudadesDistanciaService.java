package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadOrigenDestinoDTO;
import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface ICiudadesDistanciaService {
  CiudadesDistanciaOutputDTO nuevaCiudadDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO) throws ChangeSetPersister.NotFoundException;

  RutaOutputDTO busquedaCiudadDistancia(String ciudadOrigen, String ciudadDestino) throws ChangeSetPersister.NotFoundException;
}
