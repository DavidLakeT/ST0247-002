package me.DavidLake.DatosAlgoritmos2.Lab03;

import java.util.ArrayList;

public class reinasBacktracking {

    private static boolean puedoPonerReina(int c, int[] tablero) {

        for(int i = 0; i < c; i++){

            if(tablero[i] == tablero[c]) return false;
            else if(Math.abs(tablero[i] - tablero[c]) == Math.abs(i-c)) return false;
        }

        return true;
    }

    public static int nReinas(int n) {
        return nReinas(0, n, new int[n]);
    }

    private static int nReinas(int c, int n, int[] tablero) {

        int vResultado = 0;

        if(c == n) return 1;

        for(int i = 0; i < n; i++){

            tablero[c] = i;
            if(puedoPonerReina(c, tablero)) vResultado += nReinas(c+1, n, tablero);
        }

        return vResultado;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {

        return null;
    }

    private static ArrayList dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {

        return null;
    }
}
