package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
  List<Viaje> findViajeByfechaHoraPartida(LocalDateTime fechaHoraPartida);


}
