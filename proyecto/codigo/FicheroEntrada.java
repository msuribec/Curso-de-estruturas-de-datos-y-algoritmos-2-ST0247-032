package algoritmo;

import java.io.FileNotFoundException;
import java.io.File;

import java.util.HashMap;
import java.util.Scanner;

public class FicheroEntrada {

    /* Lectura vertices  */
    public static DigraphHM lecturaVerticesTxt(String nombreArchivo) throws FileNotFoundException {

        Scanner lectura = new Scanner(new File(nombreArchivo));

        int numeroDeVertices = 0;

        HashMap<String, ParejaDoubles> coordenadaPuntoVertice = new HashMap<>();

        while (lectura.hasNextLine()) {
            String vectortxt = lectura.nextLine();
            String[] vectort = vectortxt.split(" ");

            String id = vectort[0];
            double y = Double.parseDouble(vectort[1]);
            double x = Double.parseDouble(vectort[2]);

            if (!coordenadaPuntoVertice.containsKey(id)) {
                ParejaDoubles pareja = new ParejaDoubles(y, x);
                coordenadaPuntoVertice.put(id, pareja);
                numeroDeVertices++;
            }
        }

        DigraphHM grafo = new DigraphHM(numeroDeVertices, coordenadaPuntoVertice);
        return grafo;
    }

    /* Lectura Arco*/
    public static DigraphHM lecturaArcosTxt(String nombreArchivo) throws FileNotFoundException {
        DigraphHM grafo = lecturaVerticesTxt("vertices.txt");
        Scanner lectura = new Scanner(new File(nombreArchivo));
        
        while (lectura.hasNextLine()) {

            String arcotxt = lectura.nextLine();
            String[] arcot = arcotxt.split(" ");

            String origenA = arcot[0];
            String destinoA = arcot[1];
            double peso = Double.parseDouble(arcot[2]);
            
            System.out.println(origenA + " " + destinoA + " " + peso);
            grafo.addArc(origenA, destinoA, peso);
            }
        
        
        return grafo;
    }
}
