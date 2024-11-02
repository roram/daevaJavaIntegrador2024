package ar.daeva.utn.entrega.datos.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViajeOutput {
    private Long Id;
    private String Micro;
    private String FechaHoraPartida;
    private String FechaHoraLlegada;

}
