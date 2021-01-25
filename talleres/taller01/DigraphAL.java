package me.DavidLake.DatosAlgoritmos2.Taller01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class DigraphAL extends Digraph {

    private ArrayList<LinkedList<Pair<Integer,Integer>>> listaDeListas;

    public DigraphAL(int size) {

        super(size);
        listaDeListas = new ArrayList<>(size);

        for(int i = 0; i < size; i++){

            listaDeListas.set(i, new LinkedList<Pair<Integer, Integer>>());
        }
    }

    public void addArc(int source, int destination, int weight) {

        LinkedList<Pair<Integer,Integer>> destinosDeSource = listaDeListas.get(source);
        Pair<Integer,Integer> parejaNueva = new Pair<>(destination, weight);
        destinosDeSource.add(parejaNueva);
    }

    public ArrayList<Integer> getSuccessors(int vertex) {


    }

    public int getWeight(int source, int destination) {

    }

}