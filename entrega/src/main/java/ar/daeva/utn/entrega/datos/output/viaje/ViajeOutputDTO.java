package ar.daeva.utn.entrega.datos.output.viaje;

import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.models.entities.Micro;
import java.time.LocalDateTime;

public interface ViajeOutputDTO{
  Long getId();
  LocalDateTime getFechaHoraPartida();
  LocalDateTime getFechaHoraLlegada();
  Micro getMicro();
  RutaOutputDTO getRutaOutputDTO();
}
