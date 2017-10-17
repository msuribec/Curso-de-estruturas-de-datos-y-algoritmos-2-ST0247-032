/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioivdatosii;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class LaboratorioIVDatosII {
    
    /**
     * Solución al problema del agente viajero, utiliza la tecnica greedy
     * del vecino más cercano.
     * @param g grafo a recorrer.
     * @return camino.
     */
    public static ArrayList<Integer> TSP(Digraph g) {
        int menor = 0;
        ArrayList<Integer> camino = new ArrayList<Integer>();
        camino.add(menor);
        int nroNodos = 1;
        int tamaño = g.size();
        boolean[] visitados = new boolean[tamaño];
        visitados[0] = true;
        while (nroNodos != tamaño) {
            ArrayList<Integer> hijos = g.getSuccessors(menor);
            int padre = menor;
            for (int j = 0; j < tamaño-2; ++j) {
                if (!visitados[hijos.get(j)] && g.getWeight(menor, hijos.get(j)) < g.getWeight(menor, hijos.get(j+1))) {
                    menor = hijos.get(j);  
                } else {
                    menor = hijos.get(j+1);
                }
            }
            camino.add(menor);
            visitados[menor] = true;
            nroNodos++;
        }
        camino.add(0);
        return camino;
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DigraphAL grafo = new DigraphAL(4);
        grafo.addArc(0, 1, 7);
        grafo.addArc(0, 2, 15);
        grafo.addArc(0, 3, 6);
        grafo.addArc(1, 0, 2);
        grafo.addArc(1, 2, 7);
        grafo.addArc(1, 3, 3);
        grafo.addArc(2, 0, 9);
        grafo.addArc(2, 1, 6);
        grafo.addArc(2, 3, 7);
        grafo.addArc(3, 0, 10);
        grafo.addArc(3, 1, 4);
        grafo.addArc(3, 2, 8);
        System.out.println(TSP(grafo).toString());
    }
    
}
