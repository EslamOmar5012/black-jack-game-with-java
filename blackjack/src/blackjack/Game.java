/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author eslam
 */
import java.util.Random;
import java.util.Scanner;
public class Game {
   int counter = 0;
   Player players[] = new Player[4];
   Card cardDeck[] = new Card[52];
   int highScore = 0;
   
   public void generateCards(){
       int counter = 0;
       for(int i = 0 ; i < 4 ; i++){
           int value = 1;
           for(int j = 0 ; j < 13 ; j++){
               Card card  = new Card(i,j,value);
               cardDeck[counter] = card;
               if(value != 10){value++;}
               counter++;
           }
       }
   }
   
   public Card getCard(){
       Card card = null;
       while(true){
           Random rand = new Random();
           int cardNum = rand.nextInt(52);
           card = cardDeck[cardNum];
           cardDeck[cardNum] = null;
           if(card == null){
               continue;
           }
           else{
               break;
           }
       }
       return card; 
   }
   
   public void setInfo(){
       Scanner in = new Scanner(System.in);
       for(int i = 0 ; i < 3 ; i++){
           System.out.println("Enter the player No " + (i + 1) + " name :");
           players[i] = new Player();
           players[i].name = in.next();
           for(int j = 0 ; j < 2 ; j++){
              Card card[] = new Card[2];
              card[j] = getCard();
              players[i].getCards(card , j);
              players[i].updateScore(j);
           }
       }
       System.out.println("Enter the Dealer name :");
       players[3] = new Player();
       players[3].name = in.next();
       for(int j = 0 ; j < 2 ; j++){
          Card card[] = new Card[2];
          card[j] = getCard();
          players[3].getCards(card , j);
          players[3].updateScore(j);
       }
       
       
   }
   public int setHighScore(){
       int max = 0;
       for(int i = 0 ; i < 4 ; i++){
           if(max < players[i].score && players[i].score <= 21){
               max = players[i].score;
           }
       }
       highScore = max;
       return highScore;
   }
}
