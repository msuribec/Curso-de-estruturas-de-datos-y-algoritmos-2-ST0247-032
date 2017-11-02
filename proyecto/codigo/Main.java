package algoritmo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DigraphHM medellin = lectura();
    }

    public static DigraphHM lectura() throws FileNotFoundException {
        DigraphHM grafo = FicheroEntrada.lecturaArcosTxt("arcos.txt");
        return grafo;
    }
}
