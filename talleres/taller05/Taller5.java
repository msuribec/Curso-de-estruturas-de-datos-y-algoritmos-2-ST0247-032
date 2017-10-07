/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardom Jhon Chavarria
 */
public class Taller5 {
    public static void agruparVertices(Digraph gd, int ini, int fin) {
        gd.addArc(ini, fin, 1);
        gd.addArc(fin, ini, 1);
    }
        
    public static boolean mColoring(Digraph g, int m) {
        int[] colores = new int[g.size()];
        return mColoring(g, 0, colores, m);
    }
    
    /*
    * Determina si se puede colorear un nodo o no, de tal forma que sea distinto al de v.
    * return true si se puede colorear, false de lo contrario.
    */
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> hijos = g.getSuccessors(v);
        for (int i = 0; i<hijos.size();i++){
            if (colors[hijos.get(i)] == c)
                return false;
        }
        return true;
    }

    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {        
        if (v == g.size()){
            return true;
        }
        for (int i = 1; i<=m; i++){
        if (isSafe(g, v, colors, i)){
            colors[v] = i;
            if (mColoring(g, v+1, colors, m)){
                return true;
            } else {
                colors[v] = 0;
            }
        }
        }
        return false;
    }
    
    public static void main (String args[]){
        DigraphAL grafo = new DigraphAL(10);
        agruparVertices(grafo, 0, 1);
        agruparVertices(grafo, 0, 2);
        agruparVertices(grafo, 0, 5);
        agruparVertices(grafo, 2, 3);
        agruparVertices(grafo, 2, 8);
        agruparVertices(grafo, 1, 6);
        agruparVertices(grafo, 1, 7);
        agruparVertices(grafo, 3, 4);
        agruparVertices(grafo, 3, 7);
        agruparVertices(grafo, 8, 6);
        agruparVertices(grafo, 6, 4);
        agruparVertices(grafo, 8, 9);
        agruparVertices(grafo, 7, 9);
        agruparVertices(grafo, 9, 5);
        agruparVertices(grafo, 5, 4);
        System.out.println(mColoring(grafo, 3));
    }
}
