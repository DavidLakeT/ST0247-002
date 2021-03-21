package me.DavidLake.DatosAlgoritmos2.Taller07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Taller07 {

    public static void main(String[] args) {

        int[][] graph = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        Taller07 vTest = new Taller07();
        vTest.dijsktra(graph, 0);
    }


    public int findMinium(int[] distance, boolean[] finalized, int length) {

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < length; i++) {

            if (!finalized[i] && distance[i] <= min) {
                answer = i;
                min = distance[i];

            }
        }
        return answer;
    }

    public void dijsktra(int[][] graph, int src) {

        int[] distance = new int[graph.length];
        boolean[] finalized = new boolean[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(finalized, false);

        distance[src] = 0;

        for(int i =0;i<graph.length;i++){

            int u = this.findMinium(distance, finalized, graph.length);

            finalized[u] = true;

            for (int j = 0; j < graph.length; j++) {

                if (distance[u]+graph[u][j] < distance[j] && distance[u] != Integer.MAX_VALUE && !finalized[j] && graph[u][j] != 0) {
                    distance[j] = graph[u][j]+distance[u];
                }
            }

        }

        for (int e :distance){
            System.out.println(e);
        }
    }

   // public static int[] prim(Grafo g, int v) { }
}