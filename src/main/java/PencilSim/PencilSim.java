/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PencilSim;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author joexi
 */
public class PencilSim {
    
    private String paperText;
    private Integer pointHealth;
    private Integer MAX_POINT_HEALTH;
    private Integer pencilLength;
    private Integer eraserHealth;    
    private Queue<Integer> erasedWordLocs;
    
    public PencilSim(String initialText, Integer initPointHealth, Integer initPencilLength, Integer initEraserHealth){
        paperText = initialText;
        pointHealth = initPointHealth;
        MAX_POINT_HEALTH = initPointHealth;
        pencilLength = initPencilLength;
        eraserHealth = initEraserHealth;
        erasedWordLocs = new LinkedList<Integer>();
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
    
    public void erase(String textToErase){
        Integer targetPos = paperText.lastIndexOf(textToErase);
        if(targetPos == -1){
            return;
        }
        erasedWordLocs.add(targetPos);
        Integer eraserCost = calculateErasureCost(textToErase);
        Integer eraserBalance = eraserHealth - eraserCost;
        String tempPaperText = paperText.substring(0, targetPos);
        for(int i = 0; i < textToErase.length(); i++){
            if(eraserBalance < 0 && !Character.isWhitespace(textToErase.charAt(i))){
                tempPaperText = tempPaperText + textToErase.charAt(i);
                eraserBalance = eraserBalance + 1;
            }
            else if(Character.isWhitespace(textToErase.charAt(i))){
                tempPaperText = tempPaperText + " ";
            }
            else{
                tempPaperText = tempPaperText + " ";
                eraserHealth = eraserHealth - 1;
            }            
        }
        tempPaperText = tempPaperText 
            + paperText.substring(
                targetPos+textToErase.length(),
                paperText.length()
        );
        paperText = tempPaperText;                
    }
    
    public void insert(String textToInsert){
        if(editingQueueEmpty()){
            return;
        }
        String currentText = paperText;
        Integer insertStart = erasedWordLocs.remove();
        paperText = currentText.substring(0, insertStart);
        write(textToInsert);
        paperText = paperText + currentText.substring(
                insertStart+textToInsert.length(), 
                currentText.length()
        );
    }
    
    private Integer calculateErasureCost(String str){
        Integer retCost = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isWhitespace(str.charAt(i))){
                retCost = retCost + 0;
            }        
            else{
                retCost = retCost + 1;
            }
        }
        return(retCost);
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
    
    public Integer getEraserHealth(){
        return(eraserHealth);
    }
    
    public Boolean verifyErasedWordPostion(Integer e){
        return(erasedWordLocs.contains(e));
    }
    
    public Boolean editingQueueEmpty(){
        return(erasedWordLocs.isEmpty());
    }
    
}
