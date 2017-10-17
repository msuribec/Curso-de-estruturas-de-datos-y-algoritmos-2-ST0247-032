/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorioivdatosii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Solución al ejercicio en linea, utilizando tecnica greedy.
 * @author Ricardo Azopardo, Jhon Chavarria 
 */
public class EjercicioEnLinea {

    public static void main(String args[]) throws IOException {
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = Input.readLine()).equals("0 0 0")) {
            StringTokenizer tokenI = new StringTokenizer(s);
            int n = Integer.parseInt(tokenI.nextToken());
            int d = Integer.parseInt(tokenI.nextToken());
            int r = Integer.parseInt(tokenI.nextToken());
            
            tokenI = new StringTokenizer(Input.readLine());
            int[] mañana = new int[n];
            int[] tarde = new int[n];

            for (int i = 0; i < n; ++i) {
                mañana[i] = Integer.parseInt(tokenI.nextToken());
            }
            
            tokenI = new StringTokenizer(Input.readLine());
            
            for (int i = 0; i < n; ++i) {
                tarde[i] = Integer.parseInt(tokenI.nextToken());
            }

            Arrays.sort(mañana);
            Arrays.sort(tarde);

            int pagoExtra = 0;
            for (int i = 0; i < n; ++i) {
                int suma = (mañana[i] + tarde[n - 1 - i]) - d;
                pagoExtra += suma * r;
            }
            System.out.println(pagoExtra);
        }
    }
}
