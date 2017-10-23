/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriovdatosii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static laboratoriovdatosii.LaboratorioVDatosII.heldKarp;

/**
 *
 * @author Ricardo Azopardo, Jhon Chavarria
 */
public class Karen {

    public static void main(String args[]) throws IOException {
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s = Input.readLine();
        int escenarios = Integer.parseInt(s);
        while (escenarios > 0) {
            StringTokenizer tokenI = new StringTokenizer(Input.readLine());
            int filas = Integer.parseInt(tokenI.nextToken());
            int columnas = Integer.parseInt(tokenI.nextToken());
            tokenI = new StringTokenizer(Input.readLine());
            int xKarolina = Integer.parseInt(tokenI.nextToken());
            int yKarolina = Integer.parseInt(tokenI.nextToken());
            tokenI = new StringTokenizer(Input.readLine());
            int desechos = Integer.parseInt(tokenI.nextToken());
            ArrayList<Integer> dx = new ArrayList<>();
            ArrayList<Integer> dy = new ArrayList<>();
            dx.add(xKarolina);
            dy.add(yKarolina);
            for (int i = 0; i<desechos;++i){
                tokenI = new StringTokenizer(Input.readLine());
                int xDesecho = Integer.parseInt(tokenI.nextToken());
                int yDesecho = Integer.parseInt(tokenI.nextToken());
                dx.add(xDesecho);
                dy.add(yDesecho);
            }
            DigraphAM grafo = new DigraphAM(dx.size());
            
            for (int i = 0; i<dx.size();++i){
                for (int j = 0;j<dy.size();++j){
                    int peso = Math.abs(dx.get(i)-dx.get(j)) + Math.abs(dy.get(i)-dy.get(j));
                    grafo.addArc(i, j, peso);
                }
            } 
            System.out.println("The shortest path has length " + heldKarp(grafo));
        }
    }
}
