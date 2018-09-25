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
    private Integer MAX_POINT_HEALTH;
    private Integer pencilLength;
    
    public PencilSim(String initialText, Integer initPointHealth, Integer initPencilLength){
        paperText = initialText;
        pointHealth = initPointHealth;
        MAX_POINT_HEALTH = initPointHealth;
        pencilLength = initPencilLength;
    }
    
    private Integer charCost(char ch){
        if(Character.isWhitespace(ch)){
            return(0);
        }
        else if(Character.isLowerCase(ch)){
            return(1);
        }
        else if(Character.isUpperCase(ch)){
            return(2);
        }
        else{
            return(1);
        }        
    }
    
    public void write(String textToWrite){
        for(int i = 0; i < textToWrite.length(); i++){            
            pointHealth = pointHealth - charCost(textToWrite.charAt(i));
            if(pointHealth < 0){
                pointHealth = 0;
                paperText = paperText + " ";
            }
            else{
                paperText = paperText + textToWrite.charAt(i);
            }
        }
    }
    
    public void sharpen(){
        if(pencilLength > 0){
            pointHealth = MAX_POINT_HEALTH;
            pencilLength = pencilLength - 1;
        }
    }
    
    public String getPaperText(){
        return(paperText);
    }
    
    public Integer getPointHealth(){
        return(pointHealth);
    }
    
    public Integer getPencilLength(){
        return(pencilLength);
    }
    
}
