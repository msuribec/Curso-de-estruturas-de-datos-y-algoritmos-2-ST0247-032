
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class NReinasCuadrosMalos {
    public static ArrayList<Pair> huecos = new ArrayList<Pair>();
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
            Pair pareja = new Pair(r, c);
            if (puedoPonerReina(r, c, tablero) && !huecos.contains(pareja)) {                
                tablero[r] = c;             
                soluciones += nReinas(r+1, n, tablero);
            }        
        }
        return soluciones;
    }
    
    public static void main (String args []) throws IOException{
    BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int caso = 0;
        while (!(s = Input.readLine()).equals("0")) {
            caso++;
            int filas = Integer.parseInt(s);
            int [] tablero = new int [filas];
            int cont = 0;
            huecos = new ArrayList<Pair>();
            while(cont != filas){
                String linea = Input.readLine();
                if (linea.contains("*")){
                    int poshueco = linea.indexOf("*");
                    Pair hueco = new Pair(cont, poshueco);
                    huecos.add(hueco);
                }
                cont++;
            }
            System.out.println("Case " + caso + ": " + nReinas(0, filas, tablero));
        }
    }
}
