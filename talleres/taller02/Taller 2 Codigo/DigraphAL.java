/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Jairo Chavarria.
 */
public class DigraphAL extends Digraph {

    private final ArrayList<ArrayList<Pair<Integer,Integer>>> listaDeListas;

    public DigraphAL(int size) {
        super(size);
        listaDeListas = new <Integer> ArrayList();
        this.size = size;
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        ArrayList<Pair<Integer, Integer>> unaLista = listaDeListas.get(source);
        unaLista.add(new Pair(destination, weight));
    }
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Pair<Integer, Integer>> sourceList = listaDeListas.get(vertex);
        ArrayList<Integer> successors = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i++) {
            Pair<Integer, Integer> a = sourceList.get(i);
                successors.add(a.first);
            }   
        return successors;
    }

    @Override
    public int getWeight(int source, int destination) {
        ArrayList<Pair<Integer,Integer>> unaLista = listaDeListas.get(source);
        for (int i = 0; i < unaLista.size(); ++i) {
            if (unaLista.get(i).second != null) {
                return unaLista.get(i).second;
            }
        }
        return 0;
    }
}
