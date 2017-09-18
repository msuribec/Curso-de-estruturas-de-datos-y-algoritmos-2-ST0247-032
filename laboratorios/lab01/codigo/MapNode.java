/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.datos.ii;

/**
 * Clase para crear nodos con coordenadas x, y, identificador y label para el la representación
 * en grafos del mapa de medellin.
 * @author Ricardo Azopardo, Jhon Chavarria.
 */
public class MapNode {
    
    private final String x;
    private final String y;
    private final String id;
    private final String label;
    
    /**
     * Constructor de la clase MapNode.
     * @param id número identificador del nodo.
     * @param y coordenada y del nodo.
     * @param x coordenada x del nodo.
     * @param label nombre o etiqueta del nodo.
     */
    public MapNode(String id, String y, String x, String label){
        this.id = id;
        this.x = x;
        this.y = y;
        this.label = label;
    }

    /**
     * Método getter de id.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Método getter de Coordenada Y.
     * @return
     */
    public String getY() {
        return y;
    }

    /**
     * Método getter de Coordenada X.
     * @return
     */
    public String getX() {
        return x;
    }

    /**
     * Método getter de la etiqueta.
     * @return
     */
    public String getLabel() {
        return label;
    }

}
