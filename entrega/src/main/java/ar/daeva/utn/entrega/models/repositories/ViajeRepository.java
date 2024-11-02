package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Viaje;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ViajeRepository {

    List<Viaje> findAll();
    void eliminarViaje(Long id);
    Viaje findById(Long id);
    void save (Viaje viaje);
}
