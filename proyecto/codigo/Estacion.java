package me.DavidLake.DatosAlgoritmos2.Proyecto;

public class Estacion {

    private final int tipoEstacion;
    private final float tiempoRecarga;

    public Estacion(int tipoEstacion, float tiempoRecarga){

        this.tipoEstacion = tipoEstacion;
        this.tiempoRecarga = tiempoRecarga;
    }

    public float getTiempoRecarga(){ return this.tiempoRecarga; }
}
