import java.util.*;
//punto opcional C. Kefa and Park
public class lab2 {

	public static int k, m, numRestaurantes = 0;

	public static boolean[] visitados = new boolean[100000];
	public static int[] numGatos = new int[100000];

	public static Vector<Integer>[] arbol = (Vector<Integer>[]) new Vector[1000];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < arbol.length; i++) {
			arbol[i] = new Vector<Integer>();
		}

		int a, b;

		Scanner reader = new Scanner(System.in);
		System.out.println();
		k = reader.nextInt();
		m = reader.nextInt();

		for(int i = 1 ; i <= k ; i++)
			numGatos[i] = reader.nextInt();
		
		for (int i = 1; i < k; i++) {

			a = reader.nextInt();
			b = reader.nextInt();

			arbol[a].add(b);
			arbol[b].add(a);

		}
		dfs(1, numGatos[1]);
		System.out.println(numRestaurantes);

	}

	public static void dfs(int u, int cant_Gatos) {
		int totalGatos = 0;
		visitados[u] = true;
		if (cant_Gatos > m)
			return;

		boolean puedeIr = false;
		for (int v = 0; v < arbol[u].size(); v++) {
			if (!visitados[arbol[u].get(v)]) {
				if (numGatos[arbol[u].get(v)] != 0)
					totalGatos = cant_Gatos + 1;
				else
					totalGatos = 0;

				dfs(arbol[u].get(v), totalGatos);
				puedeIr = true;
			}
		}
		if (!puedeIr)
			numRestaurantes++;
	}
}

