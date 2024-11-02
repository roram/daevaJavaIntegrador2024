package ar.daeva.utn.entrega.datos.input;

import ar.daeva.utn.entrega.models.entities.Micro;
import lombok.Data;

@Data
public class ViajeInput {
    private Micro micro;
    private String fechaHoraPartida;
    private String fechaHoraLlegada;

    @Override
    public String toString(){

        return
                this.micro.toString() + " " +
                "Fecha Hora de Partida: " + this.fechaHoraPartida + " " +
                "Fecha Hora de Llegada: " + this.fechaHoraLlegada;

    }

}
