/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PencilSimTest;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import PencilSim.PencilSim;

/**
 *
 * @author joexi
 */
public class PencilSimTest {
    
    PencilSim pencilsimulator;
    
    @Before
    public void setUp() {
        pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
    }
    
    @Test
    public void whenSimulatorStartedInitialPaperTextIsAsSpecified(){
        assertEquals("This is a test piece of test paper", pencilsimulator.getPaperText());
    }

    @Test
    public void writerWantsToUsePencilToWriteAndBetterRememberThoughts(){
        pencilsimulator.write(" for testing purposes");
        assertEquals("This is a test piece of test paper for testing purposes", pencilsimulator.getPaperText());
    }
    
    @Test
    public void pencilProvidedPointValueForDurability(){
        assertEquals(Integer.valueOf(50), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void writingSpacesAndNewlinesCostsNothing(){
        pencilsimulator.write(" \n \n \n");
        assertEquals("This is a test piece of test paper \n \n \n", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(50), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void writingALowerCaseLetterCostsOne(){
        pencilsimulator.write("s");
        assertEquals("This is a test piece of test papers", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(49), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void writingAnUpperCaseLetterCostsTwo(){
        pencilsimulator.write("S");
        assertEquals("This is a test piece of test paperS", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(48), pencilsimulator.getPointHealth());
    }
}
