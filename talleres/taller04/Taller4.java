package me.DavidLake.DatosAlgoritmos2.Taller04;

import java.util.*;

public class Taller4{

    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visitados);
    }

    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {

        visitados[v] = true;
        if(v == w) return true;
        if(g.getSuccessors(v) == null) return false;

        ArrayList<Integer> vSucesores = g.getSuccessors(v);
        if(vSucesores.contains(w)) return true;

        for (Integer vSucesor : vSucesores) {

            if (!(visitados[vSucesor])) {

                if (hayCaminoDFS(g, vSucesor, w, visitados)) return true;
            }
        }
        return false;
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {

        boolean[] visitados = new boolean[g.size()];
        int suma = 0;
        if(!(hayCaminoDFS(g, inicio, fin, visitados))) return Integer.MAX_VALUE;
        int constante = inicio;
        int c = 0;
        ArrayList<Integer> min = new ArrayList<>();
        min.add(100000);
        minimoCaminoDFS(g, inicio, fin, constante, c, min);
        return min.get(0);
    }

    private static int minimoCaminoDFS(Digraph g, int v, int w, int constante, int c, ArrayList<Integer> min) {

        if(v == w)return 0;
        ArrayList<Integer> hola = g.getSuccessors(v);
        if(hola == null) return 100000;

        for(int i = 0; i < hola.size(); i++){
            if(hayCaminoDFS(g,hola.get(i), w)){
                c = g.getWeight(v, hola.get(i)) + minimoCaminoDFS(g, hola.get(i), w, constante, c, min);
            }
            if(v == constante){
                min.set(0, Math.min(min.get(0), c));
                c = 0;
            }
        }
        return c;
    }

    public static void main(String[] args){

        Digraph g = new DigraphAM(8);
        g.addArc(0,6, 90);
        g.addArc(0,3, 80);
        g.addArc(0,1,20);
        g.addArc(1, 5, 10);
        g.addArc(2,7, 20);
        g.addArc(2,3, 10);
        g.addArc(3,6,20);
        g.addArc(4, 6, 30);
        g.addArc(5,2, 10);
        g.addArc(5,3, 40);

        int elCosto = costoMinimo(g, 0, 6);
        System.out.println(elCosto);
    }
}