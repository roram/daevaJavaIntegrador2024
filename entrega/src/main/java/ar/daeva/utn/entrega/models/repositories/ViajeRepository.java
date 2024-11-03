package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViajeRepository extends CrudRepository<Viaje, Long> {
  //findByViajeAndMicro()
}
