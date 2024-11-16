package ar.daeva.utn.entrega.datos.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class ViajeInput {

    private String microPatente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaHoraPartida;
    private String ciudadOrigen;
    private String ciudadDestino;

}
