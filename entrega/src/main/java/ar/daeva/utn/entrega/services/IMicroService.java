package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMicroService {

  ResponseEntity<String> crearMicro(@RequestBody MicroInputDTO microInputDTO);

}
