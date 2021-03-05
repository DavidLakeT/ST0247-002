package me.DavidLake.DatosAlgoritmos2.Lab01;

import java.util.ArrayList;


public class Magik extends Graph{

    private Punto[][] mat;

    public Magik(int size){

        super(size);
        mat = new Punto[size+1][size+1];
    }

    @Override
    public void addArc(int source, int destination, double weight, String nombre) {

    }

    public void addArc(int source, int destination, Punto calle){

        if (!(source == 0 && destination == 0)){

            mat[source][destination] = calle;
        }
    }

    public Punto getWeight(int source, int destination){

        return mat[source][destination];
    }

    public ArrayList<Integer> getSuccessors(int vertex){

        ArrayList<Integer> np= new ArrayList<>();

        for (int i = 1; i < mat.length; i++) {

            if (mat[vertex][i] != null) {

                np.add(i);
            }
        }

        return np;
    }

    @Override
    public Union getPeso(int source, int destination) {
        return null;
    }
} 