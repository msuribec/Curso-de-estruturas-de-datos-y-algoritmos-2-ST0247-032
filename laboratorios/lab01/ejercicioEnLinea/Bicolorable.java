/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.datos.ii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author usuario
 */
public class Bicolorable {

    /**
     * Método para agrupar vertices de forma no dirigida.
     *
     * @param gd Grafo dirigido.
     * @param ini primer vertice.
     * @param fin segundo vertice.
     */
    public static void agruparVertices(Graph gd, int ini, int fin) {
        gd.addArc(ini, fin, 1);
        gd.addArc(fin, ini, 1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = Input.readLine()).equals("0")) {            
            int nVertices = Integer.parseInt(s);
            int nArcos = Integer.parseInt(Input.readLine());
            int[] colores = new int[nVertices];
            DigraphAM grafo = new DigraphAM(nVertices);
            StringTokenizer token = new StringTokenizer(Input.readLine());
            int ini = Integer.parseInt(token.nextToken());
            int fin = Integer.parseInt(token.nextToken());
            Queue<Integer> cola = new LinkedList<Integer>();
            Boolean bicolorable = true;
            colores[ini] = 1;
            cola.add(ini);

            agruparVertices(grafo, ini, fin);

            while (nArcos - 1 != 0) {
                token = new StringTokenizer(Input.readLine());
                int primero = Integer.parseInt(token.nextToken());
                int segundo = Integer.parseInt(token.nextToken());
                agruparVertices(grafo, primero, segundo);
                --nArcos;
            }

            while (!cola.isEmpty()) {
                int n = cola.poll();
                for (int v = 0; v < nVertices; ++v) {
                    if (grafo.getWeight(n, v) == 1 && colores[v] == 0) {
                        if(colores[n] == 1){
                            colores[v] = 2;
                        } else if (colores[n] == 2){
                            colores[v] = 1;
                        }
                        cola.add(v);
                    }
                    
                    else if (grafo.getWeight(n, v) == 1 && colores[v] == colores[n]) {
                        System.out.println("NOT BICOLORABLE");
                        bicolorable = false;
                        cola.clear();
                    }
                }
            }
            if (bicolorable){
                System.out.println("BICOLORABLE");
            }
        }
    }
}
