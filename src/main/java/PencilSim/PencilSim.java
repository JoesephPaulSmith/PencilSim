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
        for(int i = 0; i < textToWrite.length(); i++){
            if(!Character.isWhitespace(textToWrite.charAt(i))){
                if(Character.isUpperCase(textToWrite.charAt(i))){
                    pointHealth = pointHealth - 2;
                }
                else{
                    pointHealth = pointHealth - 1;
                }
            }            
            paperText = paperText + textToWrite.charAt(i);
        }
    }
    
    public String getPaperText(){
        return(paperText);
    }
    
    public Integer getPointHealth(){
        return(pointHealth);
    }
    
}
