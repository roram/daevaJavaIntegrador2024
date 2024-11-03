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
    public ResponseEntity<String> cargarViaje(@RequestBody ViajeInput viaje){

        String valido = "CARGADO";

        System.out.println("ENDPOINT DE cargarViaje");
        System.out.println(viaje.toString());

        this.viajesService.crearViaje(viaje);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(valido);


    }
    @GetMapping("/{id}")
    public ResponseEntity<ViajeOutput> obtenerViajePorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.viajesService.buscarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable Long id){
        this.viajesService.eliminarViaje(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ViajeOutput> putViaje(@RequestBody ViajeInput viajeNuevo, @PathVariable Long id){


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.viajesService.modificarViaje(viajeNuevo, id));
    }
}
