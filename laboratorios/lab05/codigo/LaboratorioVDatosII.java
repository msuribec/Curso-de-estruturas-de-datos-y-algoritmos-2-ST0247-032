/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriovdatosii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class LaboratorioVDatosII {
    
    /**
     * Encuentra el minimo número de pasos requeridos para transformar una palabra
     * a otra mediante tres operaciones, insertar, borrar y cambio.
     * @param a Primera Palabra.
     * @param b Segunda Palabra.
     * @return Número de pasos minimo.
     */
    public static int levenshtein(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int [][] distancias = new int [aLength][bLength];
        int i, j, costo;  
        for (i = 0; i<aLength;i++){
            distancias[i][0] = i;
        }
        for (j = 0; j<bLength;j++){
            distancias[0][j] = j;
        }       
        for (i = 1; i<aLength; i++){
            for (j = 1; j<bLength; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    costo = 0;
                } else {
                    costo = 1;
                }
                distancias[i][j] = Math.min(distancias[i-1][j] +1, Math.min(distancias[i][j-1]+1, distancias[i-1][j-1] +costo));
            }
        }
        return distancias[aLength-1][bLength-1];
    }

    
     /**
     * Llama y limpia la lista de los subconjuntos generados por el método
     * subconjuntosAux y los almacena en sets de mascaras de bits.
     * @param size
     * @return arreglo de subconjuntos.
     */
    public static ArrayList<BitmaskSet>subconjuntos(int size){
        String s = "";
        ArrayList<BitmaskSet>resultado = new ArrayList<>();
        for (int i = 0; i<size; ++i){
            s += Integer.toString(i+1);
        }        
        ArrayList<String> list = subconjuntosAux(s);
        System.out.println(list.toString());
        Set<String> conjuntos = new HashSet<>(list);
        ArrayList<String> conjuntosArreglados = new ArrayList<>(conjuntos);
        for (int c = 0; c<conjuntosArreglados.size(); ++c){
            BitmaskSet subconjunto = new BitmaskSet();
            for(int j = 0;j<=conjuntosArreglados.get(c).length()-1;++j){ 
            char numero = conjuntosArreglados.get(c).charAt(j);
            int elemento = Character.getNumericValue(numero);
            subconjunto.add(elemento);
            }
            resultado.add(subconjunto);
        }
        return resultado;
    }
    
    /**
     * Método para generar todos los subconjuntos de una cadena de caracteres.
     * @param s Cadena de caracteres.
     * @return lista de subconjuntos sin limpiar (con duplicados).
     */
    public static ArrayList<String> subconjuntosAux (String s) {
        ArrayList<String> list = new ArrayList<>();
        list.add(s.substring(0,1));
        for (int i = 0; i<s.length();++i){
            String corte = s.substring(i+1);
            String prev = corte;
            for(int j = 0; j<prev.length();++j){
                while (!prev.isEmpty()){
                    if (j >= prev.length()) break;
                    list.add(s.charAt(i)+prev.substring(j, prev.length()));
                    list.add(prev);
                    prev = prev.substring(0, prev.length()-1);
                }
                prev = corte;
            }
        }
        return list;
    }
    
    /**
     * Encuentra la longitud de la subsecuencia mas larga entre dos cadenas.
     * @param cadena primera cadena
     * @param secuencia
     * @return
     */
    public static int subsecuenciaMasLarga(String cadena1, String cadena2) {
        int i,j = 0;
        int lcadena1 = cadena1.length();
        int lcadena2 = cadena2.length();
        int[][] table = new int[lcadena1+1][lcadena2+1];

        for (i=0; i<=lcadena1; i++){
            table[i][0] = 0;
        }
        for (i=0; i<=lcadena2; i++){
            table[0][i] = 0;
        }
        
        for (i = 1; i<=lcadena1; i++) {
        for (j = 1; j<=lcadena2; j++) {
        if (cadena1.charAt(i-1) == cadena2.charAt(j-1)){
            table[i][j] = 1+table[i-1][j-1];
        } else { 
        table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
        }
        }
    }
        return table[i-1][j-1];
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(subsecuenciaMasLarga("AGGTAB", "GXTXAYB"));
        ArrayList<BitmaskSet> subconjunto = subconjuntos(3);
    }
    
}
