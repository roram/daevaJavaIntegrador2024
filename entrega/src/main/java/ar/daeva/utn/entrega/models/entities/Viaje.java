package ar.daeva.utn.entrega.models.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private Micro micro;
    private LocalDateTime fechaHoraPartida;
    private LocalDateTime fechaHoraLlegada;
    private Double distancia;

    public Viaje(Double distancia) {
        this.distancia = distancia;
    }

    public Double distanciaTotal() {
        //TODO
        return distancia;
    }
}
