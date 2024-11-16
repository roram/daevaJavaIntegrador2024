package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDateTime;
import java.util.List;

public interface ItViajesService  {

    ViajeOutput crearViaje(ViajeInput viaje) throws ChangeSetPersister.NotFoundException;
    ViajeOutput buscarPorId(Long id);
    ViajeOutput modificarViaje(ViajeInput viajeInput, Long id);
    void eliminarViaje(Long id);
    List<ViajeOutput> buscarTodos();
    List<ViajeOutput> listaViajesPorFecha(LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraLlegada);

}
