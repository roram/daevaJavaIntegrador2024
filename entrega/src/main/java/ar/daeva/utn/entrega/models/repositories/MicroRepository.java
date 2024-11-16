package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Micro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroRepository extends JpaRepository<Micro, Long> {
  Micro findMicroByPatente(String patente);
}
