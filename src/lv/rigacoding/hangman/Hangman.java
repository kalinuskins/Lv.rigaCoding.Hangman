/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rigacoding.hangman;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author oleg
 */
public class Hangman {
    private ArrayList<String> dictionary;
    
    private String word;
    
    private String guessWord;
    
    public Hangman(){
        dictionary = new ArrayList();
        dictionary.add("SUNS");
        dictionary.add("VILKS");
        dictionary.add("LAPSA");
        dictionary.add("ZILONIS");
        dictionary.add("KAMIELIS");
        dictionary.add("SKUDRA");
    }
    
    public void startNewGame(){
        Collections.shuffle(dictionary);
        
        word = dictionary.get(0); // выбирает первую строку из public Hangman
        guessWord = "";
        for(int i = 0; i < word.length(); i++){
            guessWord += "_";
        }
    }
    
    public boolean hasGuessed(){
        //return !guessWord.contains("_");
        
        return word.equals(guessWord);
    }
    
    public boolean guess(char letter){
        int position  = word.indexOf(letter); // возвращает позицию 0.
        
        if(position == -1){
            return false;
        }
        
        while(position > -1){
        String newGuessedWord = "";
        newGuessedWord = guessWord.substring(0, position)
             + letter;
        
        if(position < guessWord.length() - 1){ // без этой функции предыдущую позицию нельзя было бы проверить и использовать.
            newGuessedWord += guessWord.substring(position +1);
        }
        
        guessWord = newGuessedWord;
        
        position = word.indexOf(letter, position +1);
        }
        return true;
    }
    
    public String getGuessedWord(){ // возвращает угаданное слово 
        return guessWord;
    }
}
