package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.MicroOutputDTO;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.mapper.MicroMapper;
import ar.daeva.utn.entrega.mapper.ViajeMapper;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.entities.Viaje;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;
import ar.daeva.utn.entrega.models.repositories.ViajeRepository;
import ar.daeva.utn.entrega.services.ItViajesService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeService implements ItViajesService {
    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private MicroRepository microRepository;

    @Override
    public ViajeOutput crearViaje(ViajeInput viajeInput) {
/*
        //TODO: IMPLEMENTAR CON SERCVICIO
        Optional<Micro> micro = this.microRepository.findById(viajeInput.getMicroId());

        if(micro.isPresent()){

            Viaje nuevoViaje = ViajeMapper.INSTANCE.dtoToViaje(viajeInput);

            nuevoViaje.setMicro(micro.get());

            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(this.viajeRepository.save(nuevoViaje));

            return viajeOutput;

        }
*/
        return null;

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
    public void eliminarViaje(Long id) {
        viajeRepository.deleteById(id);
    }

    @Override
    public ViajeOutput modificarViaje(ViajeInput viajeInput, Long id) {
        /*Optional<Viaje> busquedaViaje = this.viajeRepository.findById(id);
        //TODO: IMPLEMENTAR CON SERCVICIO
        Optional<Micro> micro = this.microRepository.findById(viajeInput.getMicroId());

        if(busquedaViaje.isPresent() && micro.isPresent()){

            ViajeMapper.INSTANCE.update(busquedaViaje.get(), viajeInput);

            busquedaViaje.get().setMicro(micro.get());

            System.out.println("VIAJE ACTUALIZADO");
            System.out.println(busquedaViaje.get());

            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(busquedaViaje.get());

            this.viajeRepository.save(busquedaViaje.get());

            return viajeOutput;

        }*/

        return null;
    }

    @Override
    public List<ViajeOutput> buscarTodos() {
        return List.of();
    }

    @Override
    public List<ViajeOutput> listaViajesPorFecha(LocalDate fechaHoraPartida, LocalDate fechaHoraLlegada){
        List<Viaje> listaViajes = this.viajeRepository.findViajeByfechaHoraPartida(fechaHoraPartida);

        List<ViajeOutput> listaViajesOutput = new ArrayList<>();

        for(Viaje viaje : listaViajes){
            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(viaje);
            listaViajesOutput.add(viajeOutput);
        }

        return listaViajesOutput;

    }
}
