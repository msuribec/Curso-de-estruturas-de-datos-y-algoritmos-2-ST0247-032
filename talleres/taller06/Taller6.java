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
        /*    
        for (int i = 0; i<denominaciones.length;i++){
                int cont = 0;
                while (n >= denominaciones[i]){
                    cont++;      
                    n -= denominaciones[i];
                }                
                denominaciones[i] = cont;             
            }
            if (n != 0){
                return null;
            }
            return denominaciones;
         */
    }

    public static int recorrido(Digraph g) {
        int menor = 0;
        int mincost = 0;
        boolean[] visitados = new boolean[g.size()];
        visitados[0] = true;
        while (!contains(visitados)) {
            ArrayList<Integer> hijos = g.getSuccessors(menor);
            int padre = menor;
            for (int j = 0; j < hijos.size()-1; j++) {
                if (!visitados[hijos.get(j)] && g.getWeight(menor, hijos.get(j)) < g.getWeight(menor, hijos.get(j+1))) {
                    menor = hijos.get(j);  
                } else {
                    menor = hijos.get(j+1);
                }
            }
            mincost += g.getWeight(padre, menor);
            visitados[menor] = true;
        }
        mincost += g.getWeight(menor, 0);
        return mincost;
    }

    public static boolean contains(boolean[] visitados) {
        for (int i = 0; i < visitados.length; i++) {
            if (!visitados[i]) {
                return false;
            }
        }
        return true;
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
