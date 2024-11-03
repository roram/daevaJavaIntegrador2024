package ar.daeva.utn.entrega.services;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;

import java.util.List;

public interface ItViajesService  {

    List<ViajeOutput> buscarTodos(Long id);

    List<ViajeOutput> buscarTodos();
    ViajeOutput buscarPorId(Long id);
    ViajeOutput crearViaje(ViajeInput viaje);
    void eliminarViaje(Long id);
    ViajeOutput modificarViaje(ViajeInput viaje, Long id);
}
