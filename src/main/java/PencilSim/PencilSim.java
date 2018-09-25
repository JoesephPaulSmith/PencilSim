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
    private Integer pointHealth;
    
    public PencilSim(String initialText, Integer initPointHealth){
        paperText = initialText;
        pointHealth = initPointHealth;
    }
    
    public void write(String textToWrite){
        paperText = paperText + textToWrite;
    }
    
    public String getPaperText(){
        return(paperText);
    }
    
    public Integer getPointHealth(){
        return(pointHealth);
    }
    
}
