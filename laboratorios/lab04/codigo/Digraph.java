/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioivdatosii;

import java.util.ArrayList;

/**
 * Clase abstracta Digraph.
 * @author Ricardo Azopardo, Jhon Chavarria.
 */
public abstract class Digraph {

    /**
     *Tamaño del grafo; número de vertices.
     */
    protected int size;

    /**
     * Constructor de Graph, utiliza size como su número de vertices.
     * @param vertices
     */
    public Digraph(int vertices) {
        size = vertices;
    }

    /**
     * Método para añadir una arista, toma un vertice inicial y lo une con uno final,
     * le asigna un peso a la conexion.
     * @param source vertice inicial.
     * @param destination vertice final.
     * @param weight peso.
     */
    public abstract void addArc(int source, int destination, int weight);

    /**
     * Retorna los sucesores de un vertice determinado.
     * @param vertex vertice a selección.
     * @return retorna un arreglo con los sucesores.
     */
    public abstract ArrayList<Integer> getSuccessors(int vertex);

    /**
     * Retorna el peso de la arista entre dos vertices.
     * @param source vertice inicial.
     * @param destination vertice final.
     * @return peso.
     */
    public abstract int getWeight(int source, int destination);

    /**
     * Retorna el tamaño del grafo.
     * @return tamaño del grafo.
     */
    public int size() {
        return size;
    }
}
