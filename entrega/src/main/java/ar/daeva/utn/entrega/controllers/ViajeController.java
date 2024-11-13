package ar.daeva.utn.entrega.controllers;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.services.ItViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public ResponseEntity<ViajeOutput> cargarViaje(@RequestBody ViajeInput viaje){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.viajesService.crearViaje(viaje));

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

        ViajeOutput viajeOutput = this.viajesService.modificarViaje(viajeNuevo, id);

        if(viajeOutput == null){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(viajeOutput);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<ViajeOutput>> obtenerViajesPorFecha(@RequestParam String fechaHoraPartida,
                                                                   @RequestParam String fechaHoraLlegada)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate fechaHoraPartidaLD = LocalDate.parse(fechaHoraPartida, formatter);
        LocalDate fechaHoraLlegadaLD = LocalDate.parse(fechaHoraLlegada, formatter);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.viajesService.listaViajesPorFecha(fechaHoraPartidaLD, fechaHoraLlegadaLD));

    }
}
