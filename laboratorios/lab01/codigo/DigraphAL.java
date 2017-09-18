/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.datos.ii;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 *
 * @author Mauricio Toro, Ricardo Azopardo, Jhon Chavarria.
 * @version 1
 */
public class DigraphAL extends Graph {

    private final ArrayList<LinkedList<Pareja>> listasDeAdyacencia;

    /**
     * Constructor de grafos implementados con listas de adyacencia.
     * @param vertices número de vertices.
     */
    public DigraphAL(int vertices) {
        super(vertices);
        listasDeAdyacencia = new ArrayList<>(vertices);
        for (int c = 0; c < vertices; ++c) {
            listasDeAdyacencia.add(c, new LinkedList<>());
        }
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        LinkedList<Pareja> unaLista = listasDeAdyacencia.get(source);
        unaLista.add(new Pareja(destination, weight));
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        
        ArrayList<Integer> successors = new ArrayList<Integer>(listasDeAdyacencia.get(vertex).size());
        
        for (Pareja pair : listasDeAdyacencia.get(vertex)) {
            successors.add(pair.vertice);
        }
        
        if (successors.isEmpty()) {
            return null;
        }
        return successors;
    }

    @Override
    public int getWeight(int source, int destination) {
        for (Pareja pair : listasDeAdyacencia.get(source)) {
            if (pair.vertice == destination) {
                return pair.peso;
            }
        }
        return 0;
    }
}
