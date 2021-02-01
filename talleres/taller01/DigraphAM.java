package me.DavidLake.DatosAlgoritmos2.Taller01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DigraphAM extends Digraph {

    private int size;
    private int[][] matriz;

    public DigraphAM(int size) {

        super(size);
        this.size = size;
        matriz = new int[size][size];

        for(int i = 0; i < size; i++){

            for(int k = 0; k < size; k++){

                matriz[i][k] = 0;
            }
        }
    }

    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {

        ArrayList<Integer> sucesores = new ArrayList<>();
        ArrayList<Integer> sucesoresAux = new ArrayList<>();

        for(int i = 0; i < this.size; i++){

            sucesores.add(matriz[vertex][i]);

            if(sucesores.get(i) != 0){

                sucesoresAux.add(i);
            }
        }

        return sucesoresAux;
    }

    public int getWeight(int source, int destination) {

        return matriz[source][destination];
    }
}
