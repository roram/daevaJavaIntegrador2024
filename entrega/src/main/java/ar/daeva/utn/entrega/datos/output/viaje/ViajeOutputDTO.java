package ar.daeva.utn.entrega.datos.output.viaje;

import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.models.entities.Micro;
import org.joda.time.LocalDate;

public interface ViajeOutputDTO{
  Long getId();
  LocalDate getFechaHoraPartida();
  LocalDate getFechaHoraLlegada();
  Micro getMicro();
  RutaOutputDTO getRutaOutputDTO();
}