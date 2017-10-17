package laboratorioivdatosii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class contains algorithms for digraphs Adapted from:
 * http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 *
 * @author Mauricio Toro
 * @version 1
 */
public class DigraphAlgorithms {

    private static int minVertex(int[] dist, boolean[] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i = 0; i < dist.length; i++) {
            if (!v[i] && dist[i] < x) {
                y = i;
                x = dist[i];
            }
        }
        return y;
    }

    /**
     * Retorna el vertice con más sucesores en un grafo dirigido.
     *
     * @param gd Grafo dirigido.
     * @return número de sucesores.
     */
    public static int numSucesores(Digraph gd) {
        int verticeMax = 0;
        int mayorS = 0;

        for (int i = 0; i < gd.size() - 1; i++) {
            if (gd.getSuccessors(i).size() <= mayorS && gd.getSuccessors(i + 1).size() <= mayorS) {
            } else if (gd.getSuccessors(i).size() >= gd.getSuccessors(i + 1).size()) {
                verticeMax = i;
                mayorS = gd.getSuccessors(i).size();
            } else if (gd.getSuccessors(i).size() <= gd.getSuccessors(i + 1).size()) {
                verticeMax = i + 1;
                mayorS = gd.getSuccessors(i).size();
            }
        }
        return verticeMax;
    }

    public static int[] dijsktra(Digraph dg, int source) {
        final int[] dist = new int[dg.size()];  // shortest known distance from "s"
        final int[] pred = new int[dg.size()];  // preceeding node in path
        final boolean[] visited = new boolean[dg.size()]; // all false initially

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; //Infinity
        }
        dist[source] = 0;

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited);
            visited[next] = true;

            // The shortest path to next is dist[next] and via pred[next].
            final ArrayList<Integer> n = dg.getSuccessors(next);
            for (int j = 0; j < n.size(); j++) {
                final int v = n.get(j);
                final int d = dist[next] + dg.getWeight(next, v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred;  // (ignore pred[s]==0!)
    }

    /**
     *
     * @param pred
     * @param s
     * @param e
     * @return
     */
    public static ArrayList getPath(int[] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x != s) {
            path.add(0, x);
            x = pred[x];
        }
        path.add(0, s);
        return path;
    }
    /**
     * Método auxiliar para llamar el método de recorridos en DFS, retorna un arreglo
     * con los vertices visitados.
     * 
     * @param gd grafo a recorrer.
     * @param ini vertice inicial.
     * @param fin vertice final.
     * @return arreglo con vertices en orden de visitados o arreglo vacio si no se encuentra el vertice.
     */
    public static ArrayList DFS(Digraph gd, int ini, int fin) {
        ArrayList<Integer> visitados = new ArrayList<>(gd.size());
        boolean[] flags = new boolean[gd.size()];
        if (DFS(gd, ini, fin, visitados, flags)) {
            return visitados;
        } else {
            System.out.println("No se encontro el vertice.");
            visitados = new ArrayList<>(gd.size());
            return visitados;
        }
    }
    /**
     * Método para recorrer grafos por profundad (DFS).
     * 
     * @param gd grafo a recorrer.
     * @param ini vertice inicial.
     * @param fin vertice final. (Si se requiere recorrer el grafo 
     * completo, se puede poner un vertice inexistente o fuera de rango).
     * @param visitados Arreglo que se retornara con los vertices en orden de visitados.
     * @param flags Arreglo de booleanos para marcar vertices como visitados.
     * @return true, si encontro un camino desde el vertice inicial hasta el 
     * vertice final, false si ocurrio lo contrario.
     */
    public static boolean DFS(Digraph gd, int ini, int fin, ArrayList<Integer> visitados, boolean[] flags) {
        visitados.add(ini);
        flags[ini] = true;
        if (ini == fin) {
            return true;
        }
        ArrayList<Integer> hijos = gd.getSuccessors(ini);
        if (hijos == null) {
            return false;
        }
        for (int i = 0; i < hijos.size(); i++) {
            if (!flags[hijos.get(i)] && DFS(gd, hijos.get(i), fin, visitados, flags)) {
                return true;
            }
        }        
        return false;
    }
    
    /**
     * Método auxiliar para llamar el método tieneCiclos, recorre en DFS, todo el 
     * grafo desde todos los nodos a todos los nodos, completa todos los recorridos
     * si no los encuentra, de lo contrario imprime que si los encontro.
     * @param gd grafo a recorrer.
     * @return true si tiene ciclos, false por lo contrario
     */
    public static boolean tieneCiclos (Digraph gd){
        
        boolean [] tieneC = {false};
        for (int i = 0; i < gd.size()-1; i++){
            for (int j = 0; j<gd.size()-1; j++){
                boolean [] flags = new boolean [gd.size()];
                tieneCiclos(gd, i, j, flags, tieneC);
                if(tieneC[0]){
                    System.out.println("El grafo tiene ciclos.");
                    return true;
                }
            }
        }
        return false;
    }
    
     /**
     * Método para recorrer grafos por profundad (DFS) con el proposito de encontrar ciclos.
     * 
     * @param gd grafo a comprobar.
     * @param ini vertice inicial.
     * @param fin vertice final. (Si se requiere recorrer el grafo 
     * completo, se puede poner un vertice inexistente o fuera de rango).
     * @param flags Arreglo de booleanos para marcar vertices como visitados.
     * @param tiene
     * @return true, si completa los recorridos sin encontrar ciclos, false si 
     * encuentra ciclos, imprime indicando que los encontro.
     */
    public static boolean tieneCiclos(Digraph gd, int ini, int fin, boolean [] flags, boolean [] tiene) {        
        flags[ini] = true;
        tiene [0] = false;
        if (ini == fin) {
            return true;
        }        
        ArrayList<Integer> hijos = gd.getSuccessors(ini);
        if (hijos == null) {
            return false;
        }        
        for (int i = 0; i < hijos.size(); i++) {            
            if (!flags[hijos.get(i)]){
                if (tieneCiclos(gd, hijos.get(i), fin, flags, tiene)){
                    return true;
                }
                } else {
                tiene [0] = true;
                return false;
            }
        }        
        return false;
    }

    /**
     * Método auxiliar para llamar el método para recorrer en BFS, retorna un arreglo
     * con los vertices en orden de visitados.
     * @param gd grafo a recorrer.
     * @param ini vertice inicial.
     * @param fin vertice final.
     * @return Arreglo con vertices en orden de visitados.
     */
    public static ArrayList auxBFS(Digraph gd, int ini, int fin) {
        ArrayList<Integer> camino = new ArrayList<Integer>();
        colaBFS(gd, ini, fin, camino);
        return camino;
    }

    /**
     * Método para recorrer grafos por amplitud (BFS).
     * 
     * @param gd grafo a recorrer.
     * @param ini vertice inicial.
     * @param fin vertice final. (Si se requiere recorrer el grafo 
     * completo, se puede poner un vertice inexistente o fuera de rango).
     * @param camino
     * @return true, si encontro un camino desde el vertice inicial hasta el 
     * vertice final, false si ocurrio lo contrario.
     */
    public static boolean colaBFS(Digraph gd, int ini, int fin, ArrayList camino) {
        boolean[] flags = new boolean [gd.size()];
        Queue<Integer> cola = new LinkedList<>();
        camino.add(ini);
        flags[ini] = true;
        cola.add(ini);
        while(!cola.isEmpty()){
            ArrayList<Integer> hijos = gd.getSuccessors(cola.poll());
            if(!hijos.isEmpty()){
                for (int i = 0; i<hijos.size();i++){
                    if (!flags[hijos.get(i)]){
                        flags[hijos.get(i)] = true;
                        camino.add(hijos.get(i));
                        cola.offer(hijos.get(i));
                        if (hijos.get(i) == fin) return true;
                    }
                }
            }
        }
        return false;
        /*visitados.add(ini);
        flags[ini] = true;
        
        if (ini == fin) {
            return true;
        }
        
        ArrayList<Integer> hijos = gd.getSuccessors(ini);        
        if (hijos == null) {
            return false;
        }                
        for (int c = 0;c<hijos.size();c++){
            cola.add(hijos.get(c));
        }
        int a;
        while (!cola.isEmpty()){
            a = cola.poll();
            if (!flags[a] && BFS(gd,a, fin, visitados, flags, cola)) {
                    return true;
               }
        }
        return false;*/
    }

    /**
     * Código para dibujar el grafo en GraphViz
     * Recomiendo www.webgraphviz.com/
     * @param g
     */
    public static void dibujarGrafo(Digraph g) {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++) {
            ArrayList<Integer> lista = g.getSuccessors(i);
            for (int j = 0; j < lista.size(); j++) {
                System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\"" + g.getWeight(i, lista.get(j)) + "\"];");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {

        DigraphAL dgal = new DigraphAL(5);
        dgal.addArc(0, 1, 10);
        dgal.addArc(0, 2, 3);
        dgal.addArc(1, 2, 1);
        dgal.addArc(1, 3, 2);
        dgal.addArc(2, 1, 4);
        dgal.addArc(2, 3, 8);
        dgal.addArc(2, 4, 2);
        dgal.addArc(3, 4, 7);
        dgal.addArc(4, 3, 9);

        //System.out.println(getPath(dijsktra(dgal, 0), 0, 3));
        
        DigraphAM dgam = new DigraphAM(5);
        dgam.addArc(0, 1, 10);
        dgam.addArc(0, 2, 3);
        dgam.addArc(1, 2, 1);
        dgam.addArc(1, 3, 2);
        dgam.addArc(2, 1, 4);
        dgam.addArc(2, 3, 8);
        dgam.addArc(2, 4, 2);
        dgam.addArc(3, 4, 7);
        dgam.addArc(4, 3, 9);
        
        //System.out.println(getPath(dijsktra(dgam, 0), 0, 3));
        //DigraphAlgorithms.dibujarGrafo(dgam);
        
        DigraphAL ciclos = new DigraphAL(5);
        ciclos.addArc(0, 1, 4);
        ciclos.addArc(1, 2, 3);
        ciclos.addArc(2, 0, 3);
        ciclos.addArc(2, 3, 100);
        ciclos.addArc(3, 4, 2);
        
        DigraphAlgorithms.tieneCiclos(ciclos);
        
        System.out.println(auxBFS(ciclos, 0, 4));
    }
}
