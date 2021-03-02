package me.DavidLake.DatosAlgoritmos2.Taller05;

import java.util.ArrayList;

public class Taller5 {

    public static boolean mColoring(Digraph g, int m){

        if(g.size()<=m) return true;
        int[] colors = new int[g.size()];
        return mColoring(g, 0, colors, m);
    }

    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {

        boolean cont = false;

        for(int i = 0; i< g.size(); i++){

            for(int z = 1; z<m+1; z++){

                if(isSafe(g, i, colors, z)){

                    colors[i]=z;
                    cont = true;
                    break;
                } else{

                    cont = false;
                }
            }
            if(!cont) return false;
        }
        return true;
    }

    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> vSucesores = g.getSuccessors(v);

        for(Integer i: vSucesores) {

            if(colors[i]==c) return false;
        }
        return true;
    }
}
