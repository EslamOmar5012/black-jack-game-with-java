/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author eslam
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    static Game game = new Game();
    public static void takeTurns(GUI gui){
       Card card[] = new Card[9];
       Scanner in = new Scanner(System.in);
       boolean end = false;
       int counter = 2;
       String S_or_H = "";
       for(int i = 0 ; i < 3 ; i++){
           end = false;
           while(end == false){
               if(game.players[i].score <=21){
                   System.out.println("Player " + (i+1) + " do you want to stand or hit :");
                   S_or_H = in.next();
                   if("hit".equals(S_or_H)){
                       card[counter] = game.getCard();
                       game.players[i].getCards(card , counter);
                       game.players[i].updateScore(counter);
                       gui.updatePlayerHand(card[counter],i);
                   }
                   else if("stand".equals(S_or_H)){
                      end = true;
                   }
                   else{
                      System.out.println("Enter right text...");
                   }
               }
               else{
                   end = true;
               }
           }
       }
    }
    public static void dealerTurn(GUI gui){
        int max = game.setHighScore();
        Card card[] = new Card[9];
        int counter = 2;
        boolean end = false;
        while(end == false){
            if(game.players[3].score == 21){
                break;
            }
            else if(game.players[3].score < max){
                card[counter] = game.getCard();
                game.players[3].getCards(card , counter);
                game.players[3].updateScore(counter);
                gui.updateDealerHand(card[counter],game.cardDeck);
                counter++;
            }
            else{
                end = true;
            }
        }
   }
    public static void setScore(){
          int max = game.setHighScore();
          if( max == game.players[0].score && max == game.players[1].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else if(max == game.players[0].score && max == game.players[2].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else if(max == game.players[0].score && max == game.players[3].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else if(max == game.players[1].score && max == game.players[2].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else if(max == game.players[1].score && max == game.players[3].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else if(max == game.players[2].score && max == game.players[3].score){
              System.out.println("#################################");
              System.out.println("It is push");
              System.out.println("#################################");
          }
          else{
              if(max == game.players[0].score){
                  System.out.println("#################################");
                  System.out.println("Player 1 " + game.players[0].name + " win with score " + max);
                  System.out.println("#################################");
              }
              else if(max == game.players[1].score){
                  System.out.println("#################################");
                  System.out.println("Player 2 " + game.players[1].name + " win with score " + max);
                  System.out.println("#################################");
              }
              else if(max == game.players[2].score){
                  System.out.println("#################################");
                  System.out.println("Player 3 " + game.players[2].name + " win with score " + max);
                  System.out.println("#################################");
              }
              if(max == game.players[3].score){
                  System.out.println("#################################");
                  System.out.println("Dealer " + game.players[3].name + " win with score " + max);
                  System.out.println("#################################");
              }
          }
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generateCards();
        game.setInfo();
        gui.runGUI( game.cardDeck,
                    game.players[0].getPlayerCards(), 
                    game.players[1].getPlayerCards(),
                    game.players[2].getPlayerCards(),
                    game.players[3].getPlayerCards());
        takeTurns(gui);
        dealerTurn(gui);
        setScore();
        
    }
    
}
