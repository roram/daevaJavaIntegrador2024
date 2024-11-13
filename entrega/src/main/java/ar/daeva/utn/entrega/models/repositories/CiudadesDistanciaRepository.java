package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.CiudadesDistancia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesDistanciaRepository extends CrudRepository<CiudadesDistancia, Long> {
}
