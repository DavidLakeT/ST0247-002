package me.DavidLake.DatosAlgoritmos2.Taller09;

public class Levenshtein {

    public static void main(String[] args) {

        System.out.println(obtenerDistancia("Hola", "Hole"));
        System.out.println(obtenerDistancia("David", "Davidcito"));
    }

    public static int obtenerDistancia(String first, String second){

        if(first.equalsIgnoreCase(second)) return 0;
        if(first.length() == 0) return second.length();
        if(second.length() == 0) return first.length();

        int[][] tabla = new int[first.length() + 1][second.length() + 1];

        /*
        for(int i = 0; i < tabla.length; i++){

            for(int j = 0; j < tabla[0].length; j++){

                tabla[i][j] = 0;
            }
        } */

        for (int i = 0; i < first.length();i++){

            tabla[i][0]=i;
        }

        for (int j=0; j < second.length();j++){

            tabla[0][j]=j;
        }

        for(int i = 1; i <= first.length(); i++){

            for(int k = 1; k <= second.length(); k++){

                if(first.charAt(i-1) == second.charAt(k-1)){

                    tabla[i][k] = tabla[i-1][k-1];
                } else{

                    tabla[i][k] = 1 + Math.min(tabla[i-1][k], Math.min(tabla[i][k-1], tabla[i-1][k-1]));
                }
            }
        }

        return tabla[first.length()][second.length()];
    }
}
