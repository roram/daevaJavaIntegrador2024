package ar.daeva.utn.entrega.services.imp.util;

import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.entities.Viaje;
import ar.daeva.utn.entrega.models.entities.ciudades.Ciudad;
import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import ar.daeva.utn.entrega.models.repositories.CiudadRepository;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;
import ar.daeva.utn.entrega.models.repositories.ViajeRepository;
import ar.daeva.utn.entrega.models.repositories.ciudadesDistancia.CiudadesDistanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusquedaReferenciaService {

  @Autowired
  private CiudadesDistanciaRepository ciudadesDistanciaRepository;

  @Autowired
  private CiudadRepository ciudadRepository;

  @Autowired
  private MicroRepository microRepository;

  @Autowired
  private ViajeRepository viajeRepository;

  public CiudadesDistancia referenciaCiudadesDistancia(Long id){

    Optional<CiudadesDistancia> ciudadesDistancia = Optional.of(this.ciudadesDistanciaRepository.getReferenceById(id));

    if(ciudadesDistancia.isPresent()){
      return ciudadesDistancia.get();
    }

    return null;
  }

  public Ciudad referenciaCiudad(Long id){

    Optional<Ciudad> ciudad = Optional.of(this.ciudadRepository.getReferenceById(id));

    if(ciudad.isPresent()){
      return ciudad.get();
    }

    return null;

  }

  public Micro referenciaMicro(Long id){

    Optional<Micro> micro = Optional.of(this.microRepository.getReferenceById(id));

    if(micro.isPresent()){
      return micro.get();
    }

    return null;

  }

  public Viaje referenciaViaje(Long id){

    Optional<Viaje> viaje = Optional.of(this.viajeRepository.getReferenceById(id));

    if(viaje.isPresent()){
      return viaje.get();
    }

    return null;

  }

}
