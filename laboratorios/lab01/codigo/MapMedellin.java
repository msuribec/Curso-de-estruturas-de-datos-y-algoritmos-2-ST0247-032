/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.datos.ii;

import java.io.*;
import java.util.*;
/**
 * Clase para la construcción del mapa de medellin en una representación de grafos.
 * @author
 */
public class MapMedellin {
    private final static String vertices = "medellin_vertices.txt";
    private final static String edges = "medellin_arcos.txt";
    private static DigraphAL map = new DigraphAL(308913);
    private static HashMap<String,Integer> vMap = new HashMap(308914,1);
    
    /**
     * Método para leer los vertices y hacer un arreglo de ellos en forma de MapNodes.
     * @return Arreglo de MapNodes.
     */
    public static ArrayList<MapNode> readVertices(){
        String xc, yc, id, etiqueta;
        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<MapNode> a = new ArrayList<>();
        try {
            fr = new FileReader(vertices);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] x = line.split(" ");
                if(x.length == 4){
                    id = x[0];
                    yc = x[1];
                    xc = x[2];
                    etiqueta = x[3];
                    MapNode w = new MapNode(id,yc,xc,etiqueta);
                    a.add(w);
                }
                if(x.length == 3){
                    id = x[0];
                    yc = x[1];
                    xc = x[2];
                    MapNode w = new MapNode(id,yc,xc, "");
                    a.add(w);
                }
            }
            return a;
        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
            }
        }
        return a;
    }
    
    /**
     * Método para llenar el mapa de MapNodes.
     */
    public static void fillMap(){
        ArrayList<MapNode> x = readVertices();
        for(int i = 0; i < x.size(); ++i){
            vMap.put(x.get(i).getId(),i);
        }
    }
    
    /**
     * Método para llenar el grafo utilizando el lector y el mapa llenado previamente.
     */
    public static void fillGraph(){
        fillMap();
        String start, end, weight;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(edges);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) { 
                String[] x = line.split(" ");                
                if (x.length < 6) {
                    start = x[0];
                    end = x[1];
                    weight = x[2];
                    int w = (int)Double.parseDouble(weight);
                    if(vMap.containsKey(start) && vMap.containsKey(end)){
                        map.addArc(vMap.get(start), vMap.get(end), w);
                    }
                }
            }
            } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    public static void main(String[] args){
        fillGraph();
    }
}
