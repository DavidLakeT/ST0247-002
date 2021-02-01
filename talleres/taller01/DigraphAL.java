package me.DavidLake.DatosAlgoritmos2.Taller01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class DigraphAL extends Digraph {

    LinkedList<Pair<Integer,Integer>> listaDePares[];

    public DigraphAL(int size) {

        super(size);
        this.size = size;
        this.listaDePares = new LinkedList[size];
    }

    public void addArc(int source, int destination, int weight) {

        if(listaDePares[source] == null){

            listaDePares[source] = new LinkedList<>();
        }

        listaDePares[source].add(new Pair<>(destination, weight));
    }

    public ArrayList<Integer> getSuccessors(int vertex) {

        ArrayList<Integer> sucesores = null;
        LinkedList<Pair<Integer,Integer>> sucesoresAux = this.listaDePares[vertex];

        if(sucesoresAux != null){

            for(Pair pareja : sucesoresAux){

                if(sucesores == null){

                    sucesores = new ArrayList<Integer>();
                }

                sucesores.add((Integer) pareja.first);
            }
        }

        return sucesores;
    }

    public int getWeight(int source, int destination) {

        LinkedList<Pair<Integer,Integer>> listaAux = listaDePares[source];
        int weight = 0;

        for(Pair pareja : listaAux){

            if((int) pareja.first == destination){

                weight = (int) pareja.second;
            }
        }
        return weight;
    }
}