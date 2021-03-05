package me.DavidLake.DatosAlgoritmos2.Lab01;

public class Punto {

    double valorX;
    double valorY;
    String vNombre;
    double vDistancia;

    public Punto(double x, double y, String nombre){

        this.valorX = x;
        this.valorY = y;
        this.vNombre = nombre;
    }

    public Punto(String nombre, Double distancia) {
        this.vDistancia = distancia;
        this.vNombre = nombre;
    }
}
