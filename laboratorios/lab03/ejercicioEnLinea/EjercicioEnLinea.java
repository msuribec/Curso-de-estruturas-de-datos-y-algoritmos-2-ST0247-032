/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioiiidatosii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static laboratorioiiidatosii.LaboratorioIIIDatosII.caminoMasCorto;

/**
 *
 * @author usuario
 */
public class EjercicioEnLinea {
    /**
     * Método para agrupar vertices de forma no dirigida.
     *
     * @param gd Grafo dirigido.
     * @param ini primer vertice.
     * @param fin segundo vertice.
     * @param peso peso entre ambos vertices.
     */
    public static void agruparVertices(Digraph gd, int ini, int fin, int peso) {
        gd.addArc(ini, fin, peso);
        gd.addArc(fin, ini, peso);
    }

    /**
     * Solución del ejercicio en linea.
     * @param args arreglo de argumentos.
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while (!(s = Input.readLine()).equals("0")) {
            StringTokenizer tokenI = new StringTokenizer(s);
            int nVertices = Integer.parseInt(tokenI.nextToken()) + 1;
            int nArcos = Integer.parseInt(tokenI.nextToken());
            DigraphAL grafo = new DigraphAL(nVertices);
            StringTokenizer token = new StringTokenizer(Input.readLine());
            int ini = Integer.parseInt(token.nextToken());
            int fin = Integer.parseInt(token.nextToken());
            int pesoI = Integer.parseInt(token.nextToken());
            agruparVertices(grafo, ini, fin, pesoI);

            while (nArcos - 1 != 0) {
                token = new StringTokenizer(Input.readLine());
                int primero = Integer.parseInt(token.nextToken());
                int segundo = Integer.parseInt(token.nextToken());
                int peso = Integer.parseInt(token.nextToken());
                agruparVertices(grafo, primero, segundo, peso);
                --nArcos;
            }
            
            System.out.println(caminoMasCorto(grafo, 1, nVertices - 1));

        }
    }
}
