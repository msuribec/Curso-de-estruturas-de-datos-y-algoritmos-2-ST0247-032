/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller6;

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #6
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Chavarria
 */
public class Taller6 {

    /**
     * De un arreglo de diferentes tipos de monedas, encuentra la menor
     * combinación de monedas para lograr una cantidad n.
     *
     * @param n Cantidad a encontrar.
     * @param denominaciones Arreglo de tipos de monedas.
     * @return arreglo con las combinaciones de monedas utilizadas, null en el
     * caso de que la cantidad sea imposible de lograr.
     */
    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int monedasDevueltas;
        for (int i = 0; i < denominaciones.length; i++) {
            monedasDevueltas = n / denominaciones[i];
            n = n % denominaciones[i];
            denominaciones[i] = monedasDevueltas;
        }
        if (n != 0) {
            return null;
        }
        return denominaciones;
    }

    /**
     * Recorre todos los nodos de un grafo completo y vuelve al inicio, usando la
     * tecnica del vecino más cercano.
     * @param g grafo a recorrer.
     * @return costo minimo para recorrer todos los nodos (al ser greedy no encuentra
     * el resultado más correcto).
     */
    public static int recorrido(Digraph g) {
        int menor = 0;
        int mincost = 0;
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
            mincost += g.getWeight(padre, menor);
            visitados[menor] = true;
            nroNodos++;
        }
        mincost += g.getWeight(menor, 0);
        return mincost;
    }
    
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
        System.out.println(recorrido(grafo));
    }
}
