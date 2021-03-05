package me.DavidLake.DatosAlgoritmos2.Lab01;

import java.util.ArrayList;

public abstract class Graph{

    int vSize;

    public Graph(int vertices){

        this.vSize = vertices;
    }

    public  abstract void addArc(int source, int destination, double weight, String nombre);
    public abstract ArrayList<Integer> getSuccessors(int vertice);

    public abstract Union getPeso(int source, int destination);
    public  int size() {return this.vSize;}
}
