/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PencilSim;

/**
 *
 * @author joexi
 */
public class PencilSim {
    
    private String paperText;
    
    public PencilSim(String initialText){
        paperText = initialText;
    }
    
    public void write(String textToWrite){
        paperText = paperText + textToWrite;
    }
    
    public String getPaperText(){
        return(paperText);
    }
    
}
