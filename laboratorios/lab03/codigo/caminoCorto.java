package me.DavidLake.DatosAlgoritmos2.Lab03;

import java.util.ArrayList;

public class caminoCorto {

    public static double distanciaHamiltoniana(Digraph vGraph, int vInicial, int vFinal){

        boolean[] unvisited = new boolean[vGraph.size()];
        return auxHamilton(vGraph, vInicial, vFinal, unvisited, 0, Double.MAX_VALUE);
    }

    public static double auxHamilton(Digraph vGraph, int vInicial, int vFinal, boolean[] unvisited, double actualMaximo, double maximo){

        if(maximo >= actualMaximo)return Double.MAX_VALUE;
        if(vInicial == vFinal) return maximo;
        unvisited[vInicial]=true;
        ArrayList<Integer> sucesores = vGraph.getSuccessors(vInicial);

        for (Integer sucesore : sucesores) {

            if (unvisited[sucesore]) continue;
            else {

                double total = maximo + vGraph.getWeight(vInicial, sucesore);
                actualMaximo = Math.min(actualMaximo, auxHamilton(vGraph, sucesore, vFinal, unvisited, total, actualMaximo));
                unvisited[sucesore] = false; //Para que lo desvisite
            }
        }
        return actualMaximo;
    }
}
