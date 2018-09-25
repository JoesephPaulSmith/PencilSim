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
    @Test
    public void whenSimulatorStartedInitialPaperTextIsAsSpecified(){
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
        assertEquals("This is a test piece of test paper", pencilsimulator.getPaperText());
    }

    @Test
    public void writerWantsToUsePencilToWriteAndBetterRememberThoughts(){
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
        pencilsimulator.write(" for testing purposes");
        assertEquals("This is a test piece of test paper for testing purposes", pencilsimulator.getPaperText());
    }
    
    @Test
    public void pencilProvidedPointValueForDurability(){
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
        assertEquals(Integer.valueOf(50), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void writingSpacesAndNewlinesCostsNothing(){
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
        pencilsimulator.write(" \n \n \n");
        assertEquals(Integer.valueOf(50), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void writingALowerCaseLetterCostsOne(){
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper", 50);
        pencilsimulator.write("s");
        assertEquals(Integer.valueOf(49), pencilsimulator.getPointHealth());
    }
}
