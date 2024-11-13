package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.mapper.CiudadesDistanciaMapper;
import ar.daeva.utn.entrega.mapper.CiudadesMapper;
import ar.daeva.utn.entrega.models.entities.Ciudades;
import ar.daeva.utn.entrega.models.entities.CiudadesDistancia;
import ar.daeva.utn.entrega.models.repositories.CiudadesDistanciaRepository;
import ar.daeva.utn.entrega.services.ICiudadesDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadesDistanciaService implements ICiudadesDistanciaService {

  @Autowired
  CiudadesDistanciaRepository ciudadesDistanciaRepository;
  @Autowired
  CiudadesService ciudadesService;

  @Override
  public CiudadesDistanciaOutputDTO nuevaCiudadDistancia(CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO) {

    CiudadesOutputDTO ciudadOrigenDTO = this.ciudadesService.obtenerCiudadPorNombre(ciudadesDistanciaInputDTO.getCiudadOrigen());
    CiudadesOutputDTO ciudadDestinoDTO =this.ciudadesService.obtenerCiudadPorNombre(ciudadesDistanciaInputDTO.getCiudadDestino());

    if(ciudadOrigenDTO == null || ciudadDestinoDTO == null){
      return null;
    }

    Ciudades ciudadOrigen = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadOrigenDTO);
    Ciudades ciudadDestino = CiudadesMapper.INSTANCE.dtoOutputToCiudades(ciudadDestinoDTO);

    CiudadesDistancia nuevaDistancia = new CiudadesDistancia();

    nuevaDistancia.setCiudadOrigen(ciudadOrigen);
    nuevaDistancia.setCiudadDestino(ciudadDestino);
    nuevaDistancia.setDistancia(ciudadesDistanciaInputDTO.getDistancia());

    CiudadesDistanciaOutputDTO nuevaDistanciaDTO = CiudadesDistanciaMapper.INSTANCE.ciudadesDistanciaToDtoOutput(this.ciudadesDistanciaRepository.save(nuevaDistancia));

    return nuevaDistanciaDTO;
  }
}
