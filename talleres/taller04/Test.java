package me.DavidLake.DatosAlgoritmos2.Taller04;

import java.util.HashMap;

/**
 * Prueba la implementacion de los metodos en la clase Taller4.
 *
 * Ejecute esta clase para hacerse una idea de si su implementacion de los
 * ejercicios propuestos en el Taller de Clase #4 son correctos.
 *
 * @author Mateo Agudelo
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Camino con costo minimo -> " + convert(testCostoMinimo()));
    }

    static boolean testCostoMinimo() {
        int n = 8;

        DigraphAL g = new DigraphAL(n);
        g.addArc(1, 5, 10);
        g.addArc(0, 1, 20);
        g.addArc(4, 1, 50);
        g.addArc(4, 6, 30);
        g.addArc(0, 6, 90);
        g.addArc(6, 0, 20);
        g.addArc(0, 3, 80);
        g.addArc(5, 3, 40);
        g.addArc(3, 6, 20);
        g.addArc(5, 2, 10);
        g.addArc(2, 5, 50);
        g.addArc(3, 2, 10);
        g.addArc(2, 3, 10);
        g.addArc(2, 7, 20);

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        map.put(Pair.makePair(0, 0), 0);
        map.put(Pair.makePair(0, 1), 20);
        map.put(Pair.makePair(0, 2), 40);
        map.put(Pair.makePair(0, 3), 50);
        map.put(Pair.makePair(0, 4), -1);
        map.put(Pair.makePair(0, 5), 30);
        map.put(Pair.makePair(0, 6), 70);
        map.put(Pair.makePair(0, 7), 60);
        map.put(Pair.makePair(1, 0), 70);
        map.put(Pair.makePair(1, 1), 0);
        map.put(Pair.makePair(1, 2), 20);
        map.put(Pair.makePair(1, 3), 30);
        map.put(Pair.makePair(1, 4), -1);
        map.put(Pair.makePair(1, 5), 10);
        map.put(Pair.makePair(1, 6), 50);
        map.put(Pair.makePair(1, 7), 40);
        map.put(Pair.makePair(2, 0), 50);
        map.put(Pair.makePair(2, 1), 70);
        map.put(Pair.makePair(2, 2), 0);
        map.put(Pair.makePair(2, 3), 10);
        map.put(Pair.makePair(2, 4), -1);
        map.put(Pair.makePair(2, 5), 50);
        map.put(Pair.makePair(2, 6), 30);
        map.put(Pair.makePair(2, 7), 20);
        map.put(Pair.makePair(3, 0), 40);
        map.put(Pair.makePair(3, 1), 60);
        map.put(Pair.makePair(3, 2), 10);
        map.put(Pair.makePair(3, 3), 0);
        map.put(Pair.makePair(3, 4), -1);
        map.put(Pair.makePair(3, 5), 60);
        map.put(Pair.makePair(3, 6), 20);
        map.put(Pair.makePair(3, 7), 30);
        map.put(Pair.makePair(4, 0), 50);
        map.put(Pair.makePair(4, 1), 50);
        map.put(Pair.makePair(4, 2), 70);
        map.put(Pair.makePair(4, 3), 80);
        map.put(Pair.makePair(4, 4), 0);
        map.put(Pair.makePair(4, 5), 60);
        map.put(Pair.makePair(4, 6), 30);
        map.put(Pair.makePair(4, 7), 90);
        map.put(Pair.makePair(5, 0), 60);
        map.put(Pair.makePair(5, 1), 80);
        map.put(Pair.makePair(5, 2), 10);
        map.put(Pair.makePair(5, 3), 20);
        map.put(Pair.makePair(5, 4), -1);
        map.put(Pair.makePair(5, 5), 0);
        map.put(Pair.makePair(5, 6), 40);
        map.put(Pair.makePair(5, 7), 30);
        map.put(Pair.makePair(6, 0), 20);
        map.put(Pair.makePair(6, 1), 40);
        map.put(Pair.makePair(6, 2), 60);
        map.put(Pair.makePair(6, 3), 70);
        map.put(Pair.makePair(6, 4), -1);
        map.put(Pair.makePair(6, 5), 50);
        map.put(Pair.makePair(6, 6), 0);
        map.put(Pair.makePair(6, 7), 80);
        map.put(Pair.makePair(7, 0), -1);
        map.put(Pair.makePair(7, 1), -1);
        map.put(Pair.makePair(7, 2), -1);
        map.put(Pair.makePair(7, 3), -1);
        map.put(Pair.makePair(7, 4), -1);
        map.put(Pair.makePair(7, 5), -1);
        map.put(Pair.makePair(7, 6), -1);
        map.put(Pair.makePair(7, 7), 0);

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (Taller4.costoMinimo(g, i, j) != map.get(Pair.makePair(i, j)))
                    return false;

        return true;
    }

    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
    }

}