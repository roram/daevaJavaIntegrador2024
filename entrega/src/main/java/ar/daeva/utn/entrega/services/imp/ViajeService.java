package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.models.repositories.ViajeRepository;
import ar.daeva.utn.entrega.services.ItViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService implements ItViajesService {
    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<ViajeOutput> buscarTodos() {
        //return (List<ViajeOutput>) (List<ViajeOutput>) this.viajeRepository.findAll().stream().map();
        return null;
    }

    @Override
    public ViajeOutput buscarPorId(Long id) {
        return null;
    }

    @Override
    public int crearViaje(ViajeInput viaje) {
        return 0;
    }

    @Override
    public void eliminarViaje(Long id) {

    }

    @Override
    public ViajeOutput modificarViaje(ViajeInput viaje, Long id) {
        return null;
    }
}
