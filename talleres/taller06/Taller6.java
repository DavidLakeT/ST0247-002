package me.DavidLake.DatosAlgoritmos2.Taller06;

import java.util.ArrayList;

public class Taller6 {

    public static int[] cambioGreedy(int n, int[] denominaciones){

        int vActual =0;
        int[] vTemp = new int[100];

        for (int denominacione : denominaciones) {

            while (n >= denominacione) {

                n -= denominacione;
                vTemp[vActual] = denominacione;
                vActual++;
            }

            if (n == 0) break;
        }

        return vTemp;
    }

    public static int recorrido(Digraph g) {

        boolean[] visitados = new boolean[g.size()];
        int costo = 0;
        return recorrido(0, g, visitados, costo);
    }

    public static int recorrido(int v, Digraph g, boolean[] visitados, int costo){
        if(ok(visitados)){
            return costo + g.getWeight(v,0);
        }
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        int nodo = nodoPesoMinimo(sucesores, g, v, visitados);
        costo = costo + g.getWeight(v, nodo);
        visitados[v] = true;

        return recorrido(nodo, g, visitados, costo);
    }

    private static boolean ok(boolean[] szs){

        for (boolean sz : szs) {

            if (!sz) return false;
        }
        return true;
    }

    public static int nodoPesoMinimo(ArrayList<Integer> sucesores, Digraph g, int v, boolean[] visitados){

        int vMinimo = Integer.MAX_VALUE;
        int vNodo = 0;
        for (Integer sucesore : sucesores) {

            if (!visitados[sucesore]){

                if (vMinimo > g.getWeight(v, sucesore)) {

                    vMinimo = g.getWeight(v, sucesore);
                    vNodo = sucesore;
                }
            }
        }
        return vNodo;
    }
}