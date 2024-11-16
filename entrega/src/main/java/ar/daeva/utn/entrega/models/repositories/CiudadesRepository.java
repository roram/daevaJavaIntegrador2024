package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.ciudades.Ciudades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Long> {
  Ciudades findCiudadesByCiudad(String ciudad);


}
