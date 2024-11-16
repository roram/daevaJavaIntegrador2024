package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.mapper.MicroMapper;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;
import ar.daeva.utn.entrega.services.IMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MicroService implements IMicroService {
  @Autowired
  private MicroRepository microRepository;

  @Override
  public MicroOutputDTO crearMicro(MicroInputDTO microInputDTO) {

    // Del MicroInputDTO lo transformo a la entidad de la clase Micro
    Micro nuevoMicro = MicroMapper.INSTANCE.dtoToMicro(microInputDTO);

    // Utilizo el mapper que crea una clase Micro y la utilizo para guardar en la base de datos y
    // lo que me devuelve lo guardo y lo utilizo como respuesta.
    MicroOutputDTO microToDtoOutput = MicroMapper.INSTANCE.microToDtoOutput(this.microRepository.save(nuevoMicro));

    return  microToDtoOutput;
  }

  @Override
  public MicroOutputDTO buscarMicroById(Long id) {

    Optional<Micro> micro = this.microRepository.findById(id);

    if(micro.isPresent()){

      MicroOutputDTO microToDtoOutput = MicroMapper.INSTANCE.microToDtoOutput(micro.get());
      return microToDtoOutput;

    }

    return null;
  }
  @Override
  public void eliminarMicro(Long id) {
    this.microRepository.deleteById(id);
    
  }
  @Override
  public MicroOutputDTO modificarMicro(MicroInputDTO microInputDTO, Long id) {

    Optional<Micro> busquedaMicro = this.microRepository.findById(id);

    if(busquedaMicro.isPresent()){

      // Este mapper actualiza el objeto encontrado del micro con los elementos del microInputDTO
      MicroMapper.INSTANCE.update(busquedaMicro.get(), microInputDTO);

      // A apartir del objeto actualizado creo el MicroOutputDTO para responder
      MicroOutputDTO microOutputDTO = MicroMapper.INSTANCE.microToDtoOutput(busquedaMicro.get());

      // Si encuentro el micro lo guardo con un id, eso hace que actualice el micro existente.
      this.microRepository.save(busquedaMicro.get());

      return microOutputDTO;

    }

    return null;
  }

  @Override
  public MicroOutputDTO buscarMicroPorPatente(String patente) {
    Optional<Micro> busquedaMicro = Optional.ofNullable(this.microRepository.findMicroByPatente(patente));



    if (busquedaMicro.isPresent()){

      MicroOutputDTO microToDtoOutput = MicroMapper.INSTANCE.microToDtoOutput(busquedaMicro.get());

      return microToDtoOutput;

    }

    return null;

  }


}
