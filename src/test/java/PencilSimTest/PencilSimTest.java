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
        PencilSim pencilsimulator = new PencilSim("This is a test piece of test paper");
        assertEquals("This is a test piece of test paper", pencilsimulator.getPaperText());
    }    
}
