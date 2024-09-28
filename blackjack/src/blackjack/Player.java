/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author eslam
 */
public class Player {
    String name;
    int score = 0;
    private Card playerCards[] = new Card[11];
    
    public void getCards(Card playerCards[],int item){
        this.playerCards[item] = playerCards[item];
    }
    public void updateScore(int counter){
        if(counter < 11){
            score += playerCards[counter].getValue();
        }
    }
    
    public Card[] getPlayerCards(){
        return this.playerCards;
    }
    
}
