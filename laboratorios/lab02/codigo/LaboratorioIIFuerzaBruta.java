


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Laboratorio II - Fuerza Bruta
 * @author Ricardo Rafael Azopardo Cadenas, Jhon Jairo Chavarria Gaviria.
 */
public class LaboratorioIIFuerzaBruta {
    
    /**
     * Genera todas las permutaciones existentes de una cadena de caracteres
     * haciendo uso de fuerza bruta.
     * @param s cadena de caracteres a generar permutaciones.
     * @return ArrayList con todas las permutaciones encontradas
     */
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> list = new ArrayList<>();
        permutations("", s, list);
        return list;
    }
        
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.isEmpty()) {
            list.add(pre + pos);
        } else {
            for (int i = 0; i < pos.length(); i++) {
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1, pos.length()), list);
            }
        }
    }
    
    /**
     * Comprueba si un tablero de reinas en cada columna es valido utilizando
     * tableros en forma de arreglos.
     * @param tablero tablero con una reina por columna representado en forma de arreglo.
     * @return false si al menos una reina se ataca, true si ninguna se ataca.
     */
    public static boolean esValido(int[] tablero) {
        for (int i = 0;i<tablero.length;i++){
            for (int j = i+1;j<tablero.length;j++){
                if (tablero[i] == tablero[j] || (Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j))){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Prueba todos los tableros posibles de reinas generados por el número de columnas
     * y filas n x n, y retorna el valor de las soluciones encontradas haciendo uso
     * del metodo esValido.
     * @param n número de filas y columnas.
     * @return número de soluciones al problema de las n reinas.
     */
    public static int queens (int n){
        int cont = 0;  
        String strTable = "", strNum, strPos, numString;                                                               
        ArrayList<String> listaPermut;                                                                               
        int [] tableAjedrez = new int[n];                                                                     
                                                                                                                     
        for(int i = 0; i < n; i++){                                                                           
            strNum = Integer.toString(i);                                                                     
            strTable += strNum;                                                                                      
        }                                                                                                            
                                                                                                                     
        listaPermut = permutations(strTable);                                                                               
                                                                                                                     
        for (int k = 0; k < listaPermut.size(); k++) {                                                               
                                                                                                                     
            strPos = listaPermut.get(k);                                                                             
                                                                                                                     
            for(int j = 0; j < n; j++){                                                                              
                numString = strPos.valueOf(strPos.charAt(j));                                                        
                tableAjedrez[j] = Integer.parseInt(numString);                                                       
            }                                                                                                        
                                                                                                                     
            if (esValido(tableAjedrez)) {                                                                            
                cont++;                                                                                              
            }                                                                                                        
        }                                                                                                            
        System.out.println(cont);                                                                                    
        return cont;   
    }
    
    /**
     * Imprime un tablero de la forma representada por arreglo.
     * @param tablero
     */
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
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
