/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Jairo Chavarria.
 */
public class DigraphMA extends Digraph {

    private final int matrix[][];
    private int n;

    public DigraphMA(int n) {
        super(n);
        matrix = new int[n][n];
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        matrix[source][destination] = weight;
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors = new ArrayList<>();
        for (int c = 0; c < matrix.length; c++) {
            if (matrix[vertex][c] != 0) {
                successors.add(matrix[vertex][c]);
            }
        }
        return successors;
    }

    @Override
    public int getWeight(int source, int destination) {
        return (matrix[source][destination]);
    }

}
