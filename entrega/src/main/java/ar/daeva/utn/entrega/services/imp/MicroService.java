package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.mapper.MicroMapper;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;
import ar.daeva.utn.entrega.services.IMicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}
