/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioiiidatosii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author usuario
 */
public class LaboratorioIIIDatosII {
    
    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        for (int i = 0; i < r; ++i) {
            if (tablero[i] == c || i - tablero[i] == r - c || i + tablero[i] == r + c) {
                return false;
            }
        }
        return true;
    }
        
    public static boolean nReinasUnaSol(int n) {
        int[] tablero = new int[n];
        
        if (n == 0){
            return false;
        }
        
        if (!nReinas(0, n, tablero)){
            System.out.println("No se encontraron soluciones.");
            return false;
        } else {
            return true;
        }       
    }

    private static boolean nReinas(int r, int n, int[] tablero) {
        if (r == n) {
            imprimirTablero(tablero);
            return true;
        }
        for (int c = 0; c < n; ++c) {
            if (puedoPonerReina(r, c, tablero)) {
                tablero[r] = c;
                if (nReinas(r+1, n, tablero)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print(" " + (tablero[i] == j ? "Q" : "#"));
            }
            System.out.println();
        }
        System.out.println();
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
    public static boolean BFS(Digraph gd, int ini, int fin, ArrayList camino) {
        boolean[] flags = new boolean [gd.size()];
        Queue<Integer> cola = new LinkedList<>();
        camino.add(ini);
        flags[ini] = true;
        cola.add(ini);
        while(!cola.isEmpty()){
            ArrayList<Integer> hijos = gd.getSuccessors(cola.poll());
            if(hijos != null){
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
    }
    
    public static ArrayList BFS(Digraph gd, int ini, int fin) {
        ArrayList<Integer> camino = new ArrayList<Integer>();
        BFS(gd, ini, fin, camino);
        return camino;
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        nReinasUnaSol(27);
    }
    
}
