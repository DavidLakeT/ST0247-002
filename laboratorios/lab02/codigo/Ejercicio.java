package me.DavidLake.DatosAlgoritmos2.Lab02;

import java.util.ArrayList;

public class Ejercicio{

    public static double caminoHamiltoniano(Digraph g){

        boolean[] unvisited = new boolean[g.size()];
        return caminoHamiltoniano(g, 0, unvisited,0);
    }

    private static double caminoHamiltoniano(Digraph g, int v, boolean[] unvisited, double max){

        double vResultado = Double.MAX_VALUE;
        if(visitado(unvisited) && v == 0) return max;
        if(visitado(unvisited)&& v != 0)return Double.MAX_VALUE;
        unvisited[v]=true;
        ArrayList<Integer> sucesores = g.getSuccessors(v);

        if (visitado(unvisited)){

            for (Integer sucesor : sucesores){

                double suma = max + g.getWeight(v, sucesor);
                vResultado = Math.min(vResultado, caminoHamiltoniano(g, sucesor, unvisited, suma));
            }
            return vResultado;
        }

        for(int i = 0; i < sucesores.size(); i++){

            if(!unvisited[sucesores.get(i)]){

                double suma = max +  g.getWeight(v, sucesores.get(i));
                vResultado = Math.min(vResultado, caminoHamiltoniano(g, sucesores.get(i), unvisited, suma));
                unvisited[sucesores.get(i)] = false;
            }
        }
        return vResultado;
    }

    protected static boolean visitado(boolean[] nodos) {

        for (boolean nodo : nodos) {

            if (!nodo) return false;
        }
        return true;
    }
}
