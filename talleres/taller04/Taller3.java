
import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Chavarria
 */
public class Taller3 {

    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        for (int i = 0; i < r; ++i) {
            if (tablero[i] == c || i - tablero[i] == r - c || i + tablero[i] == r + c) {
                return false;
            }
        }
        return true;
    }

    public static int nReinas(int n) {
        int[] tablero = new int[n];
        return nReinas(0, n, tablero);
    }

    private static int nReinas(int r, int n, int[] tablero) {
        if (r == n) {
            return 1;
        }
        int soluciones = 0;
        for (int c = 0; c < n; ++c) {
            if (puedoPonerReina(r, c, tablero)) {
                tablero[r] = c;
                soluciones += nReinas(r + 1, n, tablero);
            }
        }
        return soluciones;
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

    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
        ArrayList<Integer> visitados = new ArrayList<>(g.size());
        boolean[] flags = new boolean[g.size()];
        if (dfs(g, inicio, fin, flags, visitados)) {
            return visitados;
        } else {
            System.out.println("No hay camino.");
            return null;
        }
    }
        // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        list.add(nodo);
        visitados[nodo] = true;
        if (nodo == objetivo) {
            return true;
        }
        ArrayList<Integer> hijos = g.getSuccessors(nodo);
        if (hijos == null) {
            return false;
        }
        for (int i = 0; i < hijos.size(); i++) {
            if (!visitados[hijos.get(i)] && dfs(g, hijos.get(i), objetivo, visitados, list)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
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

        System.out.println(nReinas(10));
    }
}
