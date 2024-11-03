package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Micro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MicroRepository extends CrudRepository<Micro, Long> {

}
