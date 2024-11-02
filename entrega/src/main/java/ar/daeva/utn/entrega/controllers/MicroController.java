package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.mapper.MicroMapper;
import ar.daeva.utn.entrega.services.IMicroService;
import ar.daeva.utn.entrega.services.imp.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro")
public class MicroController {

  @Autowired
  private MicroService microService;

  @PostMapping
  public ResponseEntity<String> cargarMicro(@RequestBody MicroInputDTO microInputDTO){
    System.out.println("CARGO NUEVO MICRO");

    System.out.println(microInputDTO.toString());

    this.microService.crearMicro(microInputDTO);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(microInputDTO.toString());
  }

}
