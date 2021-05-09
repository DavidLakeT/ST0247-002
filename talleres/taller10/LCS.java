package me.DavidLake.DatosAlgoritmos2.Taller10;

public class LCS {

    public static void main(String[] args) {

        System.out.println(lcs("Davidcito", "Davodcito"));
    }

    public static int lcs(String string1, String string2){

        char[] first = string1.toCharArray();
        char[] second = string2.toCharArray();
        int n = first.length;
        int m = second.length;

        int[][] tabla = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){

            for (int k = 0; k <= m; k++) {

                if(i == 0 || k == 0) { tabla[i][k] = 0; }
                else if(first[i - 1] == second[k - 1]) { tabla[i][k] = tabla[i - 1][k - 1] + 1; }
                else { tabla[i][k] = Math.max(tabla[i - 1][k], tabla[i][k - 1]); }
            }
        }
        return tabla[n][m];
    }
}
