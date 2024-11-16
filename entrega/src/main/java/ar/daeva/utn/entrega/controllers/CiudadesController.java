package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesOutputDTO;
import ar.daeva.utn.entrega.services.imp.CiudadesService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ciudad")
public class CiudadesController {

  @Autowired
  private CiudadesService ciudadesService;

  @PostMapping
  public ResponseEntity<CiudadesOutputDTO> crearNuevaCiudad(@RequestBody CiudadesInputDTO ciudadesInputDTO){
    System.out.println(ciudadesInputDTO);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(this.ciudadesService.crearCiudad(ciudadesInputDTO));
  }

  @GetMapping
  public ResponseEntity<CiudadesOutputDTO> obtenerCiudadPorNombre(@RequestParam String ciudad) throws ChangeSetPersister.NotFoundException {

    CiudadesOutputDTO ciudadesOutputDTO = this.ciudadesService.obtenerCiudadPorNombre(ciudad);

    if(ciudadesOutputDTO == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(ciudadesOutputDTO);

  }

}
