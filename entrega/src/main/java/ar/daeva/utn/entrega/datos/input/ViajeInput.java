package ar.daeva.utn.entrega.datos.input;

import ar.daeva.utn.entrega.models.entities.Micro;
import lombok.Data;

@Data
public class ViajeInput {
    private String Micro;
    private String FechaHoraPartida;
    private String FechaHoraLlegada;

}
