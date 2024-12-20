package ar.daeva.utn.entrega.models.entities.entrega;

import ar.daeva.utn.entrega.models.entities.Micro;
import ar.daeva.utn.entrega.models.repositories.MicroRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MicroRepositoryTests {

  @Autowired
  private MicroRepository microRepository;

  @Test
  @Order(1)
  public void guardarMicroTest(){
    Micro micro = Micro.builder()
            .marca("MARCA 1")
            .modelo("MODELO 1")
            .patente("PATENTE 1")
            .cant_asientos(20)
            .build();

    this.microRepository.save(micro);

    Assertions.assertThat(micro.getId()).isGreaterThan(0);
  }

  @Test
  @Order(2)
  public void obtenerMicroTest(){

    Optional<Micro> micro = this.microRepository.findById(1L);

    Assertions.assertThat(micro.get().getId()).isEqualTo(1L);

  }

  @Test
  @Order(3)
  public void actualizarMicroTest(){
    Micro micro = this.microRepository.findById(1L).get();

    micro.setModelo("MODELO 2");

    Micro microActualizado = this.microRepository.save(micro);

    Assertions.assertThat(microActualizado.getModelo()).isEqualTo("MODELO 2");

  }

  @Test
  @Order(4)
  public void borrarMicroTest(){

    this.microRepository.deleteById(1L);

    Micro micro = null;

    Optional<Micro> optionalMicro = microRepository.findById(1L);

    if(optionalMicro.isPresent()){
      micro = optionalMicro.get();
    }

    Assertions.assertThat(micro).isNull();

  }

}
