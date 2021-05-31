package me.DavidLake.DatosAlgoritmos2.Proyecto;

import java.io.IOException;

public class Main {

    static boolean mostrarHoras = false;

    public static void main(String[] args) throws IOException {

        Lector.readFile("Test.txt");
        System.out.println("Resultado (tiempo): " + Algoritmo.agenteViajero(Lector.getGrafo(), Lector.getNuevoVehiculo(), Lector.getEstaciones())); //
        System.out.println("El resultado es unicamente la suma de todas las rutas. Realmente se debe considerar la ruta de mayor tiempo.");
    }
}
