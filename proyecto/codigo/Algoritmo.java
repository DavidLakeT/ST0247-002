package me.DavidLake.DatosAlgoritmos2.Proyecto;

import java.util.*;

public class Algoritmo{

    private static int recorrido = 0;
    private static final int origen = 0;

    private static float agenteViajeroAux(boolean[] visitado, Digraph vGrafo, Vehiculo vVehiculo, float vTiempo, ArrayList<Vehiculo> vArregloVehiculos, ArrayList<Pair<Integer, Integer>> vEstaciones, boolean mostrarHoras){

        float rutaMayor = 0;
        vArregloVehiculos.add(vVehiculo);
        ArrayList<Integer> sucesores;
        float depositoActual = 0;
        float bateriaActual = vVehiculo.getTiempoMax();
        float tempVehiculo = 0;
        float tempDeposito = 0;
        float tempBateria = vVehiculo.getMaxBateria();
        float capacidadBateria = 0;

        boolean vTemp = false;

        for(int i = 0; i < visitado.length-vEstaciones.size();++i){

            if(visitado[i]){

                vTemp = true;
            } else{

                vTemp = false;
                break;
            }
        }

        if(vTemp){ return vTiempo; }

        if(Main.mostrarHoras){ System.out.print("\nRuta "+ vArregloVehiculos.size() + ":\n0" + " (0 h), "); }
        else System.out.print("\nRuta " + vArregloVehiculos.size() + ":\n0, ");

        float vehiculosActual = 0;
        float nodosActual = 0;
        float tempNodos = 0;

        for(int i = 0; i < vGrafo.size() - vEstaciones.size(); i++){

            int vMinimo = 1000000;
            int vecinoCercano = 0;
            sucesores = vGrafo.getSuccessors(recorrido);
            visitado[recorrido] = true;

            if(vehiculosActual > rutaMayor) rutaMayor = vehiculosActual;

            for(Integer vSucesor : sucesores){

                if(!visitado[vSucesor] && (vGrafo.getWeight(recorrido, vSucesor) < vMinimo) && (vSucesor < vGrafo.size() - vEstaciones.size())){

                    if(vSucesor != recorrido){

                        vMinimo = vGrafo.getWeight(recorrido, vSucesor);
                        vecinoCercano = vSucesor;
                        tempNodos = vVehiculo.getConsumo() * vGrafo.getWeight(recorrido, vecinoCercano);
                        tempDeposito = vVehiculo.getConsumo() * vGrafo.getWeight(vecinoCercano, origen);
                        nodosActual = (vGrafo.getWeight(recorrido, vecinoCercano)) / vVehiculo.getVelocidad();
                        depositoActual = (vGrafo.getWeight(vecinoCercano, origen)) / vVehiculo.getVelocidad();
                        if(vehiculosActual > rutaMayor) rutaMayor = vehiculosActual;
                    }
                }
            }

            if(i == (vGrafo.size - vEstaciones.size()) - 1) System.out.println("0 " + "("+vehiculosActual+" H)");

            if(!Lector.puedeVisitar(nodosActual, depositoActual, vVehiculo.getTiempoVisita(), bateriaActual)){

                vehiculosActual += (vGrafo.getWeight(recorrido, origen))/vVehiculo.getVelocidad();
                vTiempo += (vGrafo.getWeight(recorrido, origen))/vVehiculo.getVelocidad();
                visitado[origen] = true;

                System.out.println("0 " + "(" + vehiculosActual + " H)");
                return agenteViajeroAux(visitado, vGrafo, vVehiculo, vTiempo,vArregloVehiculos, vEstaciones, Main.mostrarHoras);
            }

            else if(Lector.puedeVisitar(nodosActual, depositoActual, vVehiculo.getTiempoVisita(), bateriaActual) && tempNodos < tempBateria){

                recorrido = vecinoCercano;
                vehiculosActual += vVehiculo.getTiempoVisita() + nodosActual;
                vTiempo += vVehiculo.getTiempoVisita() + nodosActual;
                bateriaActual -= vVehiculo.getTiempoVisita() + nodosActual;
                tempVehiculo += tempNodos;
                tempBateria -= tempNodos;
                visitado[recorrido] = true;

                if (recorrido == 0){

                    System.out.println("0 " + "(" + vehiculosActual + " H)");

                    System.out.println();
                    break;
                }

                if(Main.mostrarHoras){ System.out.print(recorrido + " " + "(" +vehiculosActual + " Horas), "); }
                else{ System.out.print(recorrido +", "); }

            }

            else if(Lector.puedeVisitar(nodosActual, depositoActual, vVehiculo.getTiempoVisita(), bateriaActual) && !Vehiculo.hayEnergia(tempNodos, tempDeposito, tempBateria)){

                vMinimo = 1000000;
                vecinoCercano = 0;
                sucesores = vGrafo.getSuccessors(recorrido);

                for(Integer sucesor : sucesores){

                    if((vGrafo.getWeight(recorrido,sucesor) < vMinimo) &&(sucesor >= vGrafo.size() - vEstaciones.size())){

                        vMinimo = vGrafo.getWeight(recorrido, sucesor);
                        vecinoCercano = sucesor;
                        nodosActual = (vGrafo.getWeight(recorrido, vecinoCercano))/vVehiculo.getVelocidad();
                        depositoActual = (vGrafo.getWeight(vecinoCercano, origen))/vVehiculo.getVelocidad();
                        tempNodos = vVehiculo.getConsumo()*vGrafo.getWeight(recorrido, vecinoCercano);
                        tempDeposito = vVehiculo.getConsumo()*vGrafo.getWeight(vecinoCercano, origen);
                        if(vehiculosActual > rutaMayor) rutaMayor = vehiculosActual;
                    }
                }

                for (Pair<Integer, Integer> vEstacion : vEstaciones){

                    if (vEstacion.getKey() == vecinoCercano){

                        if (vEstacion.getValue() == 0){ capacidadBateria = vVehiculo.getMaxBateria() / Lector.estacionLenta.getTiempoRecarga(); }
                        if (vEstacion.getValue() == 1){ capacidadBateria = vVehiculo.getMaxBateria() / Lector.estacionMedia.getTiempoRecarga(); }
                        if (vEstacion.getValue() == 2){ capacidadBateria = vVehiculo.getMaxBateria() / Lector.estacionRapida.getTiempoRecarga(); }
                    }
                }

                if((nodosActual + depositoActual + (tempVehiculo/capacidadBateria)) < bateriaActual){

                    if(tempNodos < tempBateria){

                        vehiculosActual += nodosActual + tempVehiculo/capacidadBateria;
                        recorrido = vecinoCercano;
                        vTiempo += nodosActual + tempVehiculo/capacidadBateria;
                        bateriaActual -= nodosActual + tempVehiculo/capacidadBateria;
                        tempBateria = vVehiculo.getMaxBateria();
                        tempVehiculo = 0;
                        visitado[recorrido] = true;

                        if(Main.mostrarHoras){ System.out.print(recorrido +" " + " (" +vehiculosActual+" Horas) "); }
                        else{ System.out.print(recorrido + " "); }
                    }
                }

                else{
                    vehiculosActual += (vGrafo.getWeight(recorrido, origen)) / vVehiculo.getVelocidad();
                    vTiempo += (vGrafo.getWeight(recorrido, origen)) / vVehiculo.getVelocidad();
                    visitado[origen] = true;

                    System.out.println("0 "+"("+vehiculosActual+" Horas)");
                    return agenteViajeroAux(visitado, vGrafo, vVehiculo, vTiempo,vArregloVehiculos, vEstaciones, Main.mostrarHoras);
                }
            }
        }

        System.out.println();
        //System.out.println("Ruta mayor: " + rutaMayor);
        return vTiempo;
    }

    public static float agenteViajero(Digraph vGrafo, Vehiculo vNuevoVehiculo, ArrayList<Pair<Integer,Integer>> vEstaciones){

        ArrayList <Vehiculo> vVehiculos = new ArrayList<>();
        return agenteViajeroAux(new boolean[vGrafo.size()], vGrafo, vNuevoVehiculo, 0,vVehiculos, vEstaciones, Main.mostrarHoras);
    }
}
