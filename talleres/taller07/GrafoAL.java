package me.DavidLake.DatosAlgoritmos2.Taller07;

import java.util.ArrayList;
import java.util.LinkedList;

public class GrafoAL extends Grafo {

    ArrayList<LinkedList<Pair<Integer,Integer>>> lista;

    public GrafoAL(int size) {

        super(size);
        lista= new ArrayList(size);
        for(int i=0; i< size;i++){
            lista.add(new LinkedList<Pair<Integer,Integer>>());
        }

    }

    public void addArc(int source, int destination, int weight) {
        lista.get(source).add(new Pair(destination,weight));
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        LinkedList<Pair<Integer,Integer>> list=lista.get(vertex);
        ArrayList<Integer> sucesores=new ArrayList();
        for(int i=0;i<list.size();i++){
            Pair sucesor= list.get(i);
            sucesores.add((int)sucesor.getKey());
        }
        return sucesores;
    }

    public int getWeight(int source, int destination) {
        LinkedList<Pair<Integer,Integer>> list=lista.get(source);
        for(int i=0;i<list.size();i++){
            Pair sucesor= list.get(i);
            if((int)sucesor.getKey()==destination){
                return (int)sucesor.getValue();
            }
        }
        return 0;
    }

}