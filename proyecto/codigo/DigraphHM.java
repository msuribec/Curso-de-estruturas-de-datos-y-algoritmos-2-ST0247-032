/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ricardo Azopardo, Jhon Chavarria
 */
public class DigraphHM  {
    
    private final int size;
    private final HashMap<String, ArrayList> mapa;
    private final HashMap<String, ParejaDoubles> coordenadas;

    
    /**
     * Constructor de grafos implementados con listas de adyacencia.
     * @param vertices número de vertices.
     * @param coordenadas
     */
    public DigraphHM(int vertices, HashMap<String, ParejaDoubles> coordenadas) {
        this.size = vertices;
        mapa = new HashMap<>(vertices);
        this.coordenadas = coordenadas;
    }

    public void addArc(String source, String destination, double weight) {
        ArrayList<Pareja> lista = mapa.get(source);
        lista.add(new Pareja(destination, weight));
        mapa.put(source, lista);
    }

    public ArrayList<String> getSuccessors(String vertex) {
        
        ArrayList<Pareja> lista = mapa.get(vertex);
        ArrayList<String> successors = new ArrayList<String>();
        
        for (Pareja pair : lista) {
            successors.add(pair.vertice);
        }

        if (successors.isEmpty()) {
            return null;
        }
        return successors;
    }

    public double getWeight(String source, String destination) {
        ArrayList<Pareja> lista = mapa.get(source);
        for (Pareja pair : lista) {
            if (pair.vertice.equals(destination)) {
                return pair.peso;
            }
        }
        return 0;
    }

    public int getSize() {
        return size;
    }

    public HashMap<String, ArrayList> getMapa() {
        return mapa;
    }

    public HashMap<String, ParejaDoubles> getCoordenadas() {
        return coordenadas;
    }
}
