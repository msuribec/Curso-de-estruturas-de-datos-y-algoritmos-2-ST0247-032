/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class Algoritmo {

    public double distanciaHeuristica(double xIni, double yIni, double xDest, double yDest) {
        return Math.sqrt(Math.pow(xDest - xIni, 2) + Math.pow(yDest - yIni, 2));
    }

    public ArrayList<String> AStar(DigraphHM g, String ini, String fin) {
        HashMap<String, Double> distanciasAInicio = new HashMap<>();
        HashMap<String, Double> distanciasAFinal = new HashMap<>();
        HashMap<String, ParejaDoubles> coords = g.getCoordenadas();
        Set<String> coordenadas = coords.keySet();
        Iterator iteradorfin = coordenadas.iterator();
        double xf = coords.get(fin).x;
        double yf = coords.get(fin).y;

        while (iteradorfin.hasNext()) {
            Object vertice = iteradorfin.next();
            String rvertice = (String) vertice;
            double xv = coords.get(vertice).x;
            double yv = coords.get(vertice).y;
            double distancia = distanciaHeuristica(xf, yf, xv, yv);
            distanciasAFinal.put(rvertice, distancia);
            distanciasAInicio.put(rvertice, Double.MAX_VALUE);
        }

        distanciasAInicio.put(ini, 0.0);

        return AStar(g, ini, fin, distanciasAInicio, distanciasAFinal);
    }

    public ArrayList<String> AStar(DigraphHM g, String ini, String fin, HashMap<String, Double> distancias,
            HashMap<String, Double> distanciasFin) {

        HashMap<String, Double> fcostos = new HashMap<String, Double>();
        ArrayList<String> camino = new ArrayList<String>();
        PriorityQueue<String> openSet = new PriorityQueue<String>();
        Set<String> closedSet = new HashSet<String>();
        openSet.add(ini);
        
        while (!openSet.isEmpty()) {
            String current = openSet.poll();
            closedSet.add(current);

            if (current.equals(fin)) {
                return camino;
            }

            ArrayList<String> successors = g.getSuccessors(current);
            for (String vecino : successors) {
                if (closedSet.contains(vecino)) {

                }
                double calculoCosto = fcostos.get(current) + distanciasFin.get(vecino);
                fcostos.put(vecino, calculoCosto);

                if (!openSet.contains(vecino)) {
                    openSet.add(vecino);
                } else if (calculoCosto >= fcostos.get(vecino)) {
                    continue;
                }
                camino.add(vecino);
                fcostos.put(vecino, calculoCosto);
            }
        }
        return new ArrayList<String>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
