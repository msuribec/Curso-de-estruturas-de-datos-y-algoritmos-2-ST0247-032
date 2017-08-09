/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * Clase que contiene los recorridos en profundidad (DFS) y anchura (BFS) para
 * la clase Digraph
 *
 * @author Mateo Agudelo, Ricardo Azopardo, Jhon Jairo Chavarria
 */
public class Recorridos {

    private static boolean[] nodosVisitados;
    private static ArrayList<Integer> indVertices;

    public static ArrayList<Integer> dfs(Digraph g, int start) {
        nodosVisitados = new boolean[g.size()];
        indVertices = new ArrayList<>();
        nodosVisitados[start] = true;
        indVertices.add(start);
        for (int i : g.getSuccessors(start)) {
            if (!nodosVisitados[i]) {
                dfs(g, i);
            }
        }
        return indVertices;
    }

    public static ArrayList<Integer> bfs(Digraph g, int start) {
        int[] visitados = new int[g.size()];

        for (int i = 0; i < visitados.length; i++) {
            visitados[i] = 0;
        }

        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int visitado = queue.remove(start);
            visitados[visitado] = 1;
            ArrayList<Integer> successors = g.getSuccessors(visitado);
            for (int i = 0; i < successors.size(); i++) {
                if (visitados[successors.get(i)] != 1) {
                    queue.add(successors.get(i));
                }
            }
        }
        return queue;
    }

    public static boolean hayCaminoDFS(Digraph g, int i, int j) {
        boolean visitados[] = new boolean[g.size()];
        return caminoAux(g, i, j, visitados);
    }

    public static boolean caminoAux(Digraph g, int v, int w, boolean[] visitados) {
        visitados[v] = true;
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        sucesores.add(w);
        for (int i = 0; i < g.size(); i++) {
            if (sucesores.get(i) == w || caminoAux(g, sucesores.get(i), w, visitados)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hayCaminoBFS(Digraph g, int i, int j) {
        boolean visitados[] = new boolean[g.size()];
        return caminoAux(g, i, j, visitados);
    }
}
