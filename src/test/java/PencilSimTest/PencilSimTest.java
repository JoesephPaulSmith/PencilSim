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
        pencilsimulator = new PencilSim("This is a test piece of test paper", 50, 20, 50);
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
    public void letsAssumeOtherCharactersCostOne(){
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("Total is 5.56");
        assertEquals("Total is 5.56", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(18), pencilsimulator.getPointHealth());
        
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("Phone # is 734-972-8096");
        assertEquals("Phone # is 734-972-8096", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(9), pencilsimulator.getPointHealth());
        
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("Smith Heating & Cooling");
        assertEquals("Smith Heating & Cooling", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(7), pencilsimulator.getPointHealth());
        
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("2 + 2 = 4");
        assertEquals("2 + 2 = 4", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(25), pencilsimulator.getPointHealth());
        
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("I am 'working'");
        assertEquals("I am 'working'", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(17), pencilsimulator.getPointHealth());
        
        pencilsimulator = new PencilSim("", 30, 20, 50);
        pencilsimulator.write("See: item 1, item 2, and item 3");
        assertEquals("See: item 1, item 2, and item 3", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(5), pencilsimulator.getPointHealth());
    }
    
    @Test
    public void pencilsOfIllHealthWriteSpacesEventually(){
        pencilsimulator = new PencilSim("Short pencil points", 8, 20, 50);
        pencilsimulator.write(" write");
        assertEquals("Short pencil points write", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(3), pencilsimulator.getPointHealth());
        pencilsimulator.write(" little");
        assertEquals(Integer.valueOf(0), pencilsimulator.getPointHealth());
        assertEquals("Short pencil points write lit   ", pencilsimulator.getPaperText());
    }
    
    @Test
    public void writerWantsToSharpenPencilToKeepWritingAfterPencilDulls(){
        pencilsimulator = new PencilSim("Short pencil points", 8, 20, 50);
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
        pencilsimulator = new PencilSim("Short pencils write", 10, 1, 50);
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
    
    @Test
    public void writerWantsToEraseLastInstancesOfWordsToRemoveMistakes(){
        pencilsimulator.erase("test");
        assertEquals("This is a test piece of      paper", pencilsimulator.getPaperText());
        pencilsimulator.erase("test");
        assertEquals("This is a      piece of      paper", pencilsimulator.getPaperText());        
    }
    
    @Test
    public void erasersHaveALifeOfTheirOwn(){
        assertEquals(Integer.valueOf(50), pencilsimulator.getEraserHealth());
    }
    
    @Test
    public void erasersLoseAPointPerCharacterErased(){
        pencilsimulator.erase("test");
        assertEquals("This is a test piece of      paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(46), pencilsimulator.getEraserHealth());
    }
    
    @Test
    public void erasersLoseNoPointsPerSpaceErased(){
        pencilsimulator = new PencilSim("This is a test piece\nof test paper", 50, 20, 50);
        pencilsimulator.erase("a test");
        assertEquals("This is        piece\nof test paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(45), pencilsimulator.getEraserHealth());
        pencilsimulator.erase("piece\nof");
        assertEquals("This is                 test paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(38), pencilsimulator.getEraserHealth());
    }
    
    @Test
    public void deadErasersDontErase(){
        pencilsimulator = new PencilSim("This is a test piece\nof test paper", 50, 20, 3);
        pencilsimulator.erase("a test");
        assertEquals("This is a t    piece\nof test paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(0), pencilsimulator.getEraserHealth());
        pencilsimulator = new PencilSim("This is a test piece\nof test paper", 50, 20, 3);
        pencilsimulator.erase("piece\nof");
        assertEquals("This is a test piec     test paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(0), pencilsimulator.getEraserHealth());
    }
    
    @Test
    public void simulatorTracksErasedWordPositions(){
        //assertEquals("This is a test piece of test paper", pencilsimulator.getPaperText());
        pencilsimulator.erase("test");
        assertEquals("This is a test piece of      paper", pencilsimulator.getPaperText());
        assertEquals(true, pencilsimulator.verifyErasedWordPostion(24));
        pencilsimulator.erase("test");
        assertEquals("This is a      piece of      paper", pencilsimulator.getPaperText());
        assertEquals(true, pencilsimulator.verifyErasedWordPostion(10));
    }
    
    @Test
    public void simulatorErasesNothingIfTargetWordDoesNotExist(){
        pencilsimulator.erase("garbage");
        assertEquals("This is a test piece of test paper", pencilsimulator.getPaperText());
        assertEquals(Integer.valueOf(50), pencilsimulator.getEraserHealth());
    }
    
    @Test
    public void writerWantsToEditTextToChangeWritingWithoutStartingOver(){
        pencilsimulator = new PencilSim("An apple a day keeps the doctor away", 50, 20, 50);
        pencilsimulator.erase("apple");
        assertEquals(pencilsimulator.getPaperText(), "An       a day keeps the doctor away");
        pencilsimulator.erase("doctor");
        assertEquals(pencilsimulator.getPaperText(), "An       a day keeps the        away");
        pencilsimulator.insert("onion");
        assertEquals(pencilsimulator.getPointHealth(), Integer.valueOf(45));
        assertEquals(pencilsimulator.getPaperText(), "An onion a day keeps the        away");
        assertEquals(pencilsimulator.editingQueueEmpty(), false);
        pencilsimulator.insert("spider");
        assertEquals(pencilsimulator.getPointHealth(), Integer.valueOf(39));
        assertEquals(pencilsimulator.getPaperText(), "An onion a day keeps the spider away");
        assertEquals(pencilsimulator.editingQueueEmpty(), true);
        pencilsimulator.insert(" indeed");
        assertEquals(pencilsimulator.getPaperText(), "An onion a day keeps the spider away");
    }
    
    @Test
    public void insertingTextLargerThanGapMakesCollisionsRepdByAtSymbols(){
        pencilsimulator = new PencilSim("An apple a day keeps the doctor away", 50, 20, 50);
        pencilsimulator.erase("apple");
        assertEquals(pencilsimulator.getPaperText(), "An       a day keeps the doctor away");
        pencilsimulator.insert("artichoke");
        assertEquals(pencilsimulator.getPaperText(), "An artich@k@ay keeps the doctor away");
    }
    
    @Test
    public void pencilDiesWhileInsertingTextLargerThanGapMayNotMakeCollisions(){
        pencilsimulator = new PencilSim("An apple a day keeps the doctor away", 7, 20, 50);
        pencilsimulator.erase("apple");
        assertEquals(pencilsimulator.getPaperText(), "An       a day keeps the doctor away");
        pencilsimulator.insert("artichoke");
        assertEquals(pencilsimulator.getPaperText(), "An artich@ day keeps the doctor away");
        pencilsimulator = new PencilSim("MoneyHoney", 8, 20, 50);
        pencilsimulator.erase("Money");
        assertEquals(pencilsimulator.getPaperText(), "     Honey");
        pencilsimulator.insert("artichokes");
        assertEquals(pencilsimulator.getPaperText(), "artic@@@ey");       
    }
    
}
