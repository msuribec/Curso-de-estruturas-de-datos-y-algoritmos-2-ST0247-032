/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriovdatosii;

import java.util.ArrayList;

/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 *
 * @author Mauricio Toro, Ricardo Azopardo, Jhon Chavarria.
 * @version 1
 */
public class DigraphAM extends Digraph {
    
    int matrix[][];

    /**
     * Constructor de un grafo utilizando matrices de adyacencia.
     * @param size
     */
    public DigraphAM(int size) {
        super(size);
        matrix = new int[size][size];
    }

    @Override
    public int getWeight(int source, int destination) {
        return matrix[source][destination];
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> sucesores = new ArrayList<>();
		for (int i = 0; i < size; ++i)
			if (matrix[vertex][i] != 0)
				sucesores.add(i);
                if (sucesores.isEmpty()){
                    return null;
                } else {
                    return sucesores;
                }
    }
}
