package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.MicroInputDTO;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.mapper.MicroMapper;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.services.IMicroService;
import ar.daeva.utn.entrega.services.imp.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/micro")
public class MicroController {

  @Autowired
  private MicroService microService;

  @PostMapping
  public ResponseEntity<MicroOutputDTO> cargarMicro(@RequestBody MicroInputDTO microInputDTO){

    //Respondo el código 201 de creado y la entidad Micro que voy a guardar
    return ResponseEntity.status(HttpStatus.CREATED).body(this.microService.crearMicro(microInputDTO));

  }

  @GetMapping("/{id}")
  public ResponseEntity<MicroOutputDTO> obtenerMicroById(@PathVariable Long id){

    MicroOutputDTO microOutputDTO = this.microService.buscarMicroById(id);

    if(microOutputDTO == null){
      return  ResponseEntity.notFound().build();
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(microOutputDTO);

  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarMicro(@PathVariable Long id){
    this.microService.eliminarMicro(id);
    return ResponseEntity
            .status(HttpStatus.OK)
            .build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<MicroOutputDTO> actualizarMicro(@RequestBody MicroInputDTO microInputDTO, @PathVariable Long id){
    MicroOutputDTO microOutputDTO = this.microService.modificarMicro(microInputDTO, id);

    if(microOutputDTO == null){
      return  ResponseEntity.notFound().build();
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(microOutputDTO);
  }

  @GetMapping
  public ResponseEntity<MicroOutputDTO> buscarMicroPorPatente(@RequestParam String patente){

    MicroOutputDTO microOutputDTO = this.microService.buscarMicroPorPatente(patente);

    if(microOutputDTO == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(microOutputDTO);

  }

}
