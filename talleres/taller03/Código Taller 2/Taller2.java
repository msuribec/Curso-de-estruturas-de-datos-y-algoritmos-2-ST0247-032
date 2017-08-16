
import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 *
 * @author Mauricio Toro, Mateo Agudelo, Ricardo Azopardo, Jhon Chavarria
 */
public class Taller2 {

    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if ( start >= nums.length ) return target == 0;                                                              
        return sumaGrupo( start + 1, nums, target - nums[start] ) || sumaGrupo( start + 1, nums, target );  
    }

    public static  ArrayList<String>combinations(String s) {
        ArrayList<String>list = new ArrayList<>();
        combinations("", s, list);
        return list;
    }

    // recomendacion
    private static void combinations(String pre, String pos, ArrayList<String> list) {
        if (pos.isEmpty()) {
            list.add(pre);
        } else {
            for (int i = 0; i < pos.length(); i++) {
                combinations(pre + pos.charAt(i),pos.substring(i+1, pos.length()),list);
            }
        }
    }

    public static ArrayList<String> permutations(String s) {
        ArrayList<String> list = new ArrayList<>();
        permutations("", s, list);
        return list;
    }
//123
    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.isEmpty()) {
            list.add(pre + pos);
        } else {
            for (int i = 0; i < pos.length(); i++) {
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1, pos.length()), list);
            }
        }
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
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean esValido(int[] tablero) {
        return false;
        // complete...
    }

    public static int queens(int n) {
        return 0;
        // complete...
    }

    public static void main(String[] args) {
        combinations("abc");
    }
}
