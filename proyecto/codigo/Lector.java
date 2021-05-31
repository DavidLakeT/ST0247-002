package me.DavidLake.DatosAlgoritmos2.Proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Lector {

    public static Estacion estacionLenta;
    public static Estacion estacionMedia;
    public static Estacion estacionRapida;

    private static final ArrayList<Pair<Integer,Integer>> vEstaciones = new ArrayList<>();
    private static Digraph vGrafo;
    private static Vehiculo nuevoVehiculo;

    public static void readFile(String archivo) throws IOException {

        BufferedReader vBufferedReader = new BufferedReader(new FileReader(archivo));

        String vLine;

        HashMap<String, Integer> vVariablesInteger = new HashMap<>();
        HashMap<String, Float> vVariablesFloat = new HashMap<>();

        for(int i = 0; i <= 12; i++){

            vLine = vBufferedReader.readLine();
            String[] vArregloLinea = vLine.split(" ");
            String vIndice = vArregloLinea[0];

            switch (vIndice) {
                case "n" -> vVariablesInteger.put("cantidadNodos", Integer.parseInt(vArregloLinea[2]));
                case "m" -> vVariablesInteger.put("cantidadClientes", Integer.parseInt(vArregloLinea[2]));
                case "u" -> vVariablesInteger.put("cantidadEstaciones", Integer.parseInt(vArregloLinea[2]));
                case "breaks" -> vVariablesInteger.put("breaks", Integer.parseInt(vArregloLinea[2]));
                case "r" -> vVariablesFloat.put("consumo", Float.parseFloat(vArregloLinea[2]));
                case "speed" -> vVariablesFloat.put("velocidad", Float.parseFloat(vArregloLinea[2]));
                case "Tmax" -> vVariablesFloat.put("tiempoMax", Float.parseFloat(vArregloLinea[2]));
                case "Smax" -> vVariablesFloat.put("tiempoMaxCarga", Float.parseFloat(vArregloLinea[2]));
                case "st_customer" -> vVariablesFloat.put("tiempoVisita", Float.parseFloat(vArregloLinea[2]));
                case "Q" -> vVariablesFloat.put("capacidadBateria", Float.parseFloat(vArregloLinea[2]));
            }
        }

        System.out.println("Variables integer leidas: " + vVariablesInteger.entrySet());
        System.out.println("Variables float leidas: " + vVariablesFloat.entrySet());

        int cantidadNodos = vVariablesInteger.get("cantidadNodos");
        nuevoVehiculo = new Vehiculo(vVariablesFloat.get("velocidad"), vVariablesFloat.get("consumo"), 0, vVariablesFloat.get("capacidadBateria"), vVariablesFloat.get("tiempoVisita"), vVariablesFloat.get("tiempoMax"));
        Pair<Float,Float>[] arreglo = new Pair[cantidadNodos];
        vGrafo = new DigraphAM(cantidadNodos);

        while (!(vLine = vBufferedReader.readLine()).equals("l")){

            if(vLine.equalsIgnoreCase("")) continue;

            String[] arregloLinea = vLine.split(" ");
            String vTipo = arregloLinea[4];
            int vID = Integer.parseInt(arregloLinea[0]);

            if(arregloLinea.length == 6){

                if (vTipo.equals("d") || vTipo.equals("c")){

                    arreglo[vID] = new Pair<>(Float.parseFloat(arregloLinea[2]), Float.parseFloat(arregloLinea[3]));
                }

                if(vTipo.equals("s")){

                    arreglo[vID] = new Pair<>(Float.parseFloat(arregloLinea[2]) ,Float.parseFloat(arregloLinea[3]));
                    vEstaciones.add(new Pair<>(Integer.parseInt(arregloLinea[0]), Integer.parseInt(arregloLinea[5])));
                }
            }
        }

        vBufferedReader.readLine();
        vLine = vBufferedReader.readLine();
        String[] arregloLinea = vLine.split(" ");
        estacionLenta = new Estacion(0, Float.parseFloat(arregloLinea[3]));

        vLine = vBufferedReader.readLine();
        arregloLinea = vLine.split(" ");
        estacionMedia = new Estacion(1, Float.parseFloat(arregloLinea[3]));

        vLine = vBufferedReader.readLine();
        arregloLinea = vLine.split(" ");
        estacionRapida = new Estacion(2, Float.parseFloat(arregloLinea[3]));

        for (int i = 0; i < cantidadNodos; i++){

            for (int j = 0; j < cantidadNodos; j++){

                vGrafo.addArc(i,j,(int)Math.sqrt(Math.pow(arreglo[i].getKey() - arreglo[j].getKey(), 2) + Math.pow(arreglo[i].getValue() - arreglo[j].getValue(), 2)));
            }
        }
    }

    //Getters - Setters

    public static ArrayList<Pair<Integer, Integer>> getEstaciones(){ return vEstaciones; }
    public static Digraph getGrafo(){ return vGrafo; }
    public static Vehiculo getNuevoVehiculo(){ return nuevoVehiculo; }

    public static boolean puedeVisitar(float costoNodo, float costoDeposito, float costoCliente, float tiempoRestante){

        if ((costoNodo + costoDeposito + costoCliente) > tiempoRestante) return false;

        return true;
    }
}
