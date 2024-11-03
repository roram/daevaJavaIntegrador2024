package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMicroService {

  MicroOutputDTO crearMicro(@RequestBody MicroInputDTO microInputDTO);

  MicroOutputDTO buscarMicroById(Long id);

    void eliminarMicro(Long id);

  MicroOutputDTO modificarMicro(MicroInputDTO microInputDTO, Long id);
}
