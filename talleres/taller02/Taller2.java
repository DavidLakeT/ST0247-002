package me.DavidLake.DatosAlgoritmos2.Taller02;

import java.util.LinkedList;

public class Taller2 {

    public static LinkedList<String> combinations(String str){

        LinkedList<String> respuesta = new LinkedList<String>();
        combinations("", str, respuesta);
        return respuesta;
    }

    private static void combinations(String loQueLlevo, String loQueMeFalta, LinkedList<String> list){

        if(loQueMeFalta.length() == 0) list.add(loQueLlevo);

        else{ combinations(loQueLlevo + loQueMeFalta.substring(0,1), loQueMeFalta.substring(1), list);
        combinations(loQueLlevo, loQueMeFalta.substring(1), list); }
    }

    public static LinkedList<String> permutations(String s) {
        LinkedList<String> respuesta = new LinkedList<String>();
        permutations("", s, respuesta);
        return respuesta;
    }

    private static void permutations(String loQueLlevo, String loQueMeFalta, LinkedList<String> list) {

        if (loQueMeFalta.length() == 0) list.add(loQueLlevo);

        else {
            for (int i = 0; i < loQueMeFalta.length(); i++) {

                permutations(loQueLlevo + loQueMeFalta.substring(i, i + 1), loQueMeFalta.replace(loQueMeFalta.substring(i, i + 1), ""), list);
            }
        }
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

    /**
     * Metodo auxiliar verifica si el tablero implementado es correcto
     * es decir rodas las reinas se posicionan de foma correcta
     *
     * @param  tablero un arreglo con las posiciones de un tablero de ajedrez
     * @return true si es verdaderos, false de lo contrario
     */
    public static boolean esValido(int[] tablero) {

        return true;
    }

    /**
     * Metodo que muestra el numero de posibles soluciones al problema
     *
     *
     * @param  n numero de reinas
     * @return numero de soluciones
     */
    public static int queens(int n) {
        return queens(n, 0, new int[n]);
    }

    private static int queens(int n, int columna, int[] tablero){

        return 1;
    }

}