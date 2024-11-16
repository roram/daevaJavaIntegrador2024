package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.ciudades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
  Ciudad findCiudadesByCiudad(String ciudad);

}
