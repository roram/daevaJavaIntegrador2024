package ar.daeva.utn.entrega.models.repositories;

import ar.daeva.utn.entrega.models.entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
/*
    List<Viaje> findAll();
    void eliminarViaje(Long id);
    Viaje findById(long id);
    void save (Viaje viaje);*/
}
