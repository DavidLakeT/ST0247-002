package me.DavidLake.DatosAlgoritmos2.Taller01;

import java.util.ArrayList;

public class DigraphAM extends Digraph {

    private int[][] matriz;

    public DigraphAM(int size) {

        super(size);

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

        for(int i = 0; i < this.size; i++){

            for(int k = 0; k < this.size; k++){

                System.out.println(matriz[i][k]);

                if(matriz[i][k] != 0){

                    sucesores.add(matriz[i][k]);
                }
            }
        }

        return sucesores;
    }

    public int getWeight(int source, int destination) {

        return matriz[source][destination];
    }
}
