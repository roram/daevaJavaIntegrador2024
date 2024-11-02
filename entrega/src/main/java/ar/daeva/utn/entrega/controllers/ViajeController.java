package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.services.ItViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")

public class ViajeController {
    @Autowired
    private ItViajesService viajesService;

    @GetMapping
    public ResponseEntity<List<ViajeOutput>> obtenerViajes(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.viajesService.buscarTodos());
    }
    @PostMapping
    public ResponseEntity<String> cargarViaje(@RequestBody ViajeInput turno){


        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.viajesService.crearTurno(turno).toString());


    }
}
