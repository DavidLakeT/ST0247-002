package me.DavidLake.DatosAlgoritmos2.Proyecto;

public class Vehiculo {

    //private final float recorridoActual;
    private final float consumo;
    private final float tiempoMax;
    private final float tiempoVisita;
    private final float capacidadBateria;
    private final float velocidad;

    public Vehiculo(float velocidad, float consumo, float recorridoActual, float capacidadBateria, float tiempoVisita, float tiempoMax){

        //this.recorridoActual = recorridoActual;
        this.consumo = consumo;
        this.tiempoMax = tiempoMax;
        this.tiempoVisita = tiempoVisita;
        this.capacidadBateria = capacidadBateria;
        this.velocidad = velocidad;
    }

    public static boolean hayEnergia(float costoNodo, float costoEstacion, float capacidadBateria){

        if((costoNodo + costoEstacion) > capacidadBateria) return false;

        return true;
    }

    public float getConsumo(){ return this.consumo; }
    public float getTiempoMax(){ return this.tiempoMax; }
    public float getTiempoVisita() { return this.tiempoVisita; }
    public float getMaxBateria() { return this.capacidadBateria; }
    public float getVelocidad() { return this.velocidad; }
}
