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
        pencilsimulator = new PencilSim("This is a test piece of test paper", 50, 20);
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
    
    @Test
    public void pencilsOfIllHealthWriteSpacesEventually(){
        pencilsimulator = new PencilSim("Short pencil points", 8, 20);
        pencilsimulator.write(" write");
        assertEquals("Short pencil points write", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(3), pencilsimulator.getPointHealth());
        pencilsimulator.write(" little");
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals("Short pencil points write lit   ", pencilsimulator.getPaperText());
    }
    
    @Test
    public void writerWantsToSharpenPencilToKeepWritingAfterPencilDulls(){
        pencilsimulator = new PencilSim("Short pencil points", 8, 20);
        pencilsimulator.write(" write");
        assertEquals("Short pencil points write", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(3), pencilsimulator.getPointHealth());
        pencilsimulator.write(" little");
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals("Short pencil points write lit   ", pencilsimulator.getPaperText());
        pencilsimulator.sharpen();
        assertEquals(Integer.valueOf(8), pencilsimulator.getPointHealth());
        pencilsimulator.write("poetry");
        assertEquals(Integer.valueOf(2), pencilsimulator.getPointHealth());
        assertEquals("Short pencil points write lit   poetry", pencilsimulator.getPaperText());
    }
    
    @Test
    public void pencilComesWithACertainLength(){
        assertEquals(Integer.valueOf(20), pencilsimulator.getPencilLength());     
    }
    
    @Test
    public void sharpeningPencilReducesLengthByOne(){
        pencilsimulator.write(" with some text");
        assertEquals(Integer.valueOf(38), pencilsimulator.getPointHealth());
        pencilsimulator.sharpen();
        assertEquals(Integer.valueOf(50), pencilsimulator.getPointHealth());
        assertEquals(Integer.valueOf(19), pencilsimulator.getPencilLength());     
    }
    
    @Test
    public void pencilsOfShortLengthWriteVeryLittle(){
        pencilsimulator = new PencilSim("Short pencils write", 10, 1);
        pencilsimulator.write(" very few words");
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals("Short pencils write very few wor  ", pencilsimulator.getPaperText());
        pencilsimulator.sharpen();
        assertEquals(Integer.valueOf(10), pencilsimulator.getPointHealth());
        assertEquals(Integer.valueOf(0), pencilsimulator.getPencilLength());
        pencilsimulator.write("of great importance");
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals("Short pencils write very few wor  of great imp       ", pencilsimulator.getPaperText());
        pencilsimulator.sharpen();
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals(Integer.valueOf(0), pencilsimulator.getPencilLength());
        pencilsimulator.write("I say");
        assertEquals("Short pencils write very few wor  of great imp            ", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
    }
}
