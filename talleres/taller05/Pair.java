package me.DavidLake.DatosAlgoritmos2.Taller05;

import java.util.Objects;

public class Pair<F, S> {

    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        int hashFirst = (first == null) ? 0 : first.hashCode();
        int hashSecond = (second == null) ? 0 : second.hashCode();
        return hashFirst ^ hashSecond;
    }

    @Override
    public String toString() {
        return "Pair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
    }

    public static <A, B> Pair<A, B> makePair(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}