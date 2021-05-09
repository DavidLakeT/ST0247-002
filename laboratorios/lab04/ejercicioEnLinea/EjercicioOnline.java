package me.DavidLake.DatosAlgoritmos2.Lab04;

public class EjercicioOnline{

    public static int minimo(int cantidadRutas, int duracionMax, int costoHoraExtra, int[] a, int[] b){

        int resultado = 0;

        for(int i = 0; i < cantidadRutas; i++){

            int cantidadHoras = a[i] + b[cantidadRutas-i-1];

            if(cantidadHoras > duracionMax){

                resultado += Math.abs(cantidadHoras - duracionMax);
            }
        }

        return resultado * costoHoraExtra;
    }
}
