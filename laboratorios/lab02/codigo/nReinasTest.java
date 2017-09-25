/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class nReinasTest {
    
    /**
     * Test de pruebas del método queens.
     */
    @Test
    public void queensTest() {        
        assertEquals(LaboratorioIIFuerzaBruta.queens(1),1);
        assertEquals(LaboratorioIIFuerzaBruta.queens(2),0);
        assertEquals(LaboratorioIIFuerzaBruta.queens(3),0);
        assertEquals(LaboratorioIIFuerzaBruta.queens(4),2);
        assertEquals(LaboratorioIIFuerzaBruta.queens(5),10);
        assertEquals(LaboratorioIIFuerzaBruta.queens(6),4);
        assertEquals(LaboratorioIIFuerzaBruta.queens(7),40);
        assertEquals(LaboratorioIIFuerzaBruta.queens(8),92);
        assertEquals(LaboratorioIIFuerzaBruta.queens(9),352);
        assertEquals(LaboratorioIIFuerzaBruta.queens(10),724);       
    }
}
