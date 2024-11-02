package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
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
  public ResponseEntity<String> crearMicro(MicroInputDTO microInputDTO) {


    System.out.println("DATOS DE INGREO DE DTO DEL MICRO");
    System.out.println(microInputDTO.toString());

    Micro nuevoMicro = MicroMapper.INSTANCE.dtoToMicro(microInputDTO);

    System.out.println("CREANDO NUEVO MICRO DE MAPPER");
    System.out.println(nuevoMicro.toString());
    System.out.println("CLASE");
    System.out.println(nuevoMicro.getClass());

    return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.microRepository.save(nuevoMicro).toString());

  }

}
