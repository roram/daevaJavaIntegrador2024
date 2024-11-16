package ar.daeva.utn.entrega.services.imp;

import ar.daeva.utn.entrega.datos.input.ViajeInput;
import ar.daeva.utn.entrega.datos.output.ViajeOutput;
import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.mapper.ViajeMapper;
import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.entities.Viaje;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;
import ar.daeva.utn.entrega.models.repositories.ViajeRepository;
import ar.daeva.utn.entrega.services.ItViajesService;
import ar.daeva.utn.entrega.services.imp.util.BusquedaReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeService implements ItViajesService {
    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private MicroRepository microRepository;

    @Autowired
    private BusquedaReferenciaService busquedaReferenciaService;

    @Autowired
    private  CiudadesDistanciaService ciudadesDistanciaService;

    @Override
    public ViajeOutput crearViaje(ViajeInput viajeInput) throws ChangeSetPersister.NotFoundException {

        Optional<Micro> micro = Optional.ofNullable(this.microRepository.findMicroByPatente(viajeInput.getMicroPatente()));
        Optional<RutaOutputDTO> rutaOutputDTO = Optional.of(this.ciudadesDistanciaService.busquedaCiudadDistancia(viajeInput.getCiudadOrigen(), viajeInput.getCiudadDestino()));

        if(micro.isPresent() && rutaOutputDTO.isPresent()){

            Viaje nuevoViaje = ViajeMapper.INSTANCE.dtoToViaje(viajeInput);

            nuevoViaje.setMicro(this.busquedaReferenciaService.referenciaMicro(micro.get().getId()));
            nuevoViaje.setRuta(this.busquedaReferenciaService.referenciaCiudadesDistancia(rutaOutputDTO.get().getId()));

            // Calculo de fecha y hora de llegada
            BigDecimal tiempoBD = BigDecimal.valueOf((double)rutaOutputDTO.get().getDistancia()/(double)90);

            Integer hs = tiempoBD.intValue();
            BigDecimal tiempoDecimal = tiempoBD.subtract(BigDecimal.valueOf(hs));
            Integer mn = tiempoDecimal.multiply(BigDecimal.valueOf(60)).intValue();

            LocalDateTime horaLlegada = viajeInput.getFechaHoraPartida().plusHours(hs).plusMinutes(mn);

            nuevoViaje.setFechaHoraLlegada(horaLlegada);

            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(this.viajeRepository.save(nuevoViaje));

            viajeOutput.setRutaOutputDTO(rutaOutputDTO.get());

            return viajeOutput;

        }

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
    public List<ViajeOutput> listaViajesPorFecha(LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraLlegada){

        List<Viaje> listaViajes = this.viajeRepository.findViajeByfechaHoraPartida(fechaHoraPartida);

        List<ViajeOutput> listaViajesOutput = new ArrayList<>();

        for(Viaje viaje : listaViajes){
            ViajeOutput viajeOutput = ViajeMapper.INSTANCE.viajeToDtoOutput(viaje);
            listaViajesOutput.add(viajeOutput);
        }

        return listaViajesOutput;

    }
}
