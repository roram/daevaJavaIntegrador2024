package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.mapper.ViajeMapper;
import ar.daeva.utn.entrega.models.entities.Viaje;
import ar.daeva.utn.entrega.models.repositories.ViajeRepository;
import ar.daeva.utn.entrega.services.ItViajesService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService implements ItViajesService {
    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<ViajeOutput> buscarTodos(Long id) {
        //return (List<ViajeOutput>) (List<ViajeOutput>) this.viajeRepository.findAll().stream().map();


        return null;
    }

    @Override
    public List<ViajeOutput> buscarTodos() {
        return List.of();
    }

    @Override
    public ViajeOutput buscarPorId(Long id) {
        Optional<Viaje> viaje = this.viajeRepository.findById(id);
        if(viaje.isPresent()) {
            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(viaje.get());
            return viajeOutput;

        }
        return null;
    }

    @Override
    public ViajeOutput crearViaje(ViajeInput viaje) {

        Viaje nuevoViaje = ViajeMapper.INSTANCE.dtoToViaje(new ViajeInput());

        ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(this.viajeRepository.save(nuevoViaje));

        return viajeOutput;
    }

    @Override
    public void eliminarViaje(Long id) {
        viajeRepository.deleteById(id);

    }

    @Override
    public ViajeOutput modificarViaje(ViajeInput viaje, Long id) {
        return null;
    }
}
