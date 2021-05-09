package me.DavidLake.DatosAlgoritmos2.Lab04;

import java.util.ArrayList;

public class Lab04 {

    public static int ejercicioFedEx(Digraph vGrafo) {

        boolean[] visited = new boolean[vGrafo.size()];

        int nodoActual = 0, actual = 0, tempNodo = 0;

        for(int i = 0; i < vGrafo.size(); i++){

            int temp = Integer.MAX_VALUE;
            visited[nodoActual] = true;
            ArrayList<Integer> sucesores = vGrafo.getSuccessors(nodoActual);

            for(Integer vSucesor : sucesores){

                int peso = vGrafo.getWeight(nodoActual, vSucesor);

                if((!visited[vSucesor] && peso < temp) || ((i == vGrafo.size()-1) && (vSucesor == 0))){

                    temp = peso;
                    tempNodo = vSucesor;
                }
            }

            actual += temp;
            nodoActual = tempNodo;
        }

        return actual;
    }
}
