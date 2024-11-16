package ar.daeva.utn.entrega.datos.input;

import ar.daeva.utn.entrega.models.entities.Micro;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Data
public class ViajeInput {

    private String microPatente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate fechaHoraPartida;
    private String ciudadOrigen;
    private String ciudadDestino;

}
