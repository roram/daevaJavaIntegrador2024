package ar.daeva.utn.entrega.models.repositories.ciudadesDistancia;

import ar.daeva.utn.entrega.datos.output.ciudades.RutaOutputDTO;
import ar.daeva.utn.entrega.models.entities.ciudades.CiudadesDistancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesDistanciaRepository extends JpaRepository<CiudadesDistancia, Long> {

  @Query(value = "SELECT ciudades_distancia.id AS id, ciudadOrigen.ciudad AS ciudadOrigen, ciudadDestino.ciudad AS ciudadDestino, ciudades_distancia.distancia AS distancia\n" +
                 "FROM ciudades_distancia\n" +
                 "INNER JOIN ciudades AS ciudadOrigen\n" +
                 "INNER JOIN ciudades AS ciudadDestino\n" +
                 "ON ciudades_distancia.ciudad_origen_id = ciudadOrigen.id AND ciudades_distancia.ciudad_destino_id = ciudadDestino.id\n" +
                 "WHERE ciudadOrigen.id = :co AND ciudadDestino.id = :cd;", nativeQuery = true)
  RutaOutputDTO findByCiudadOrigenAndCiudadDestino(@Param("co") Long idCiudadOrigen, @Param("cd") Long IdCiudadDestino);

}
