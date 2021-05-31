package me.DavidLake.DatosAlgoritmos2.Proyecto;

import java.util.ArrayList;

public class DigraphAM extends Digraph {

    int[][] matriz;

    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
    }

    public int getWeight(int source, int destination) {
        return matriz[source][destination];
    }

    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
        matriz[destination][source] = weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (matriz[vertex][j] != 0) {
                lista.add(j);
            }
        }
        return lista;
    }
}