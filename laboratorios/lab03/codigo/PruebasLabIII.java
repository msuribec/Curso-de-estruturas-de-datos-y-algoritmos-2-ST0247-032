/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import laboratorioiiidatosii.DigraphAL;
import laboratorioiiidatosii.LaboratorioIIIDatosII;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PruebasLabIII {
    
    /**
     * Test de pruebas del método queens.
     */
    @Test
    public void queensTest() {        
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(0),false);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(1),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(2),false);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(3),false);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(4),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(5),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(6),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(7),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(8),true);
        assertEquals(LaboratorioIIIDatosII.nReinasUnaSol(9),true);       
    }
    
    @Test
    public void BFSTest(){
        ArrayList<Integer> prueba1 = new ArrayList<Integer>();
        prueba1.addAll(Arrays.asList(0,1,2,3,5,4,6,7));
        
        DigraphAL grafo1 = new DigraphAL(8);
        grafo1.addArc(0, 1, 0);
        grafo1.addArc(0, 2, 0);
        grafo1.addArc(0, 3, 0);
        grafo1.addArc(2, 5, 0);
        grafo1.addArc(2, 4, 0);
        grafo1.addArc(4, 6, 0);
        grafo1.addArc(4, 7, 0);
        
        assertEquals(LaboratorioIIIDatosII.BFS(grafo1, 0, 7), prueba1);
        
        ArrayList<Integer> prueba2 = new ArrayList<Integer>();
        prueba2.addAll(Arrays.asList(0,1,2,3,7,6,5,4, 8, 11, 9, 10));
        
        DigraphAL grafo2 = new DigraphAL(12);
        grafo2.addArc(0, 1, 0);
        grafo2.addArc(0, 2, 0);
        grafo2.addArc(0, 3, 0);
        grafo2.addArc(0, 7, 0);
        grafo2.addArc(1, 6, 0);
        grafo2.addArc(1, 2, 0);
        grafo2.addArc(2, 5, 0);
        grafo2.addArc(3, 4, 0);
        grafo2.addArc(7, 8, 0);
        grafo2.addArc(6, 0, 0);
        grafo2.addArc(5, 11, 0);
        grafo2.addArc(8, 9, 0);
        grafo2.addArc(8, 10, 0);
        
        assertEquals(LaboratorioIIIDatosII.BFS(grafo2, 0, 10), prueba2);
    }
}
