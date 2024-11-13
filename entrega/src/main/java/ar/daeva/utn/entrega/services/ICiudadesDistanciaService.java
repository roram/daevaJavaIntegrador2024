package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;

public interface ICiudadesDistanciaService {
  CiudadesDistanciaOutputDTO nuevaCiudadDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO);
}
