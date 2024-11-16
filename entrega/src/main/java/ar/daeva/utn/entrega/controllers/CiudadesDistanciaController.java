package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.ciudades.CiudadesDistanciaInputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.datos.output.ciudades.CiudadesDistanciaOutputDTO;
import ar.daeva.utn.entrega.services.imp.CiudadesDistanciaService;
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
@RequestMapping("/ruta")
public class CiudadesDistanciaController {

  @Autowired
  CiudadesDistanciaService ciudadesDistanciaService;

  @PostMapping
  public ResponseEntity<CiudadesDistanciaOutputDTO> crearNuevaRuta(@RequestBody CiudadesDistanciaInputDTO ciudadesDistanciaInputDTO) throws ChangeSetPersister.NotFoundException {

    CiudadesDistanciaOutputDTO nuevaRuta = this.ciudadesDistanciaService.nuevaCiudadDistancia(ciudadesDistanciaInputDTO);

    if(nuevaRuta == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRuta);

  }

  @GetMapping
  public ResponseEntity<RutaOutputDTO> buscarRuta(@RequestParam String ciudadOrigenParam,
                                                  @RequestParam String ciudadDestinoParam) throws ChangeSetPersister.NotFoundException {
    RutaOutputDTO busquedaRuta = this.ciudadesDistanciaService.busquedaCiudadDistancia(ciudadOrigenParam, ciudadDestinoParam);

    if(busquedaRuta == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(busquedaRuta);
  }

}
