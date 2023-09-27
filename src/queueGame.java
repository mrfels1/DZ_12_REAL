import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class queueGame {
    public ConcurrentLinkedQueue<Character> player1Queue;
    public ConcurrentLinkedQueue<Character> player2Queue;
    public queueGame(String player1str, String player2str){
        this.player1Queue = new ConcurrentLinkedQueue<Character>();
        this.player2Queue = new ConcurrentLinkedQueue<Character>();
        for (int i = 0; i < player1str.length(); i++) {
            player1Queue.add(player1str.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < player2str.length(); i++) {
            player2Queue.add(player2str.charAt(i));
        }
        printStacks();
    }

    public void printStacks(){
        System.out.println("Player 1: "+ player1Queue.toString());
        System.out.println("Player 2: "+ player2Queue.toString());
    }

    public Character getP1Card(){
        if (player1Queue.isEmpty()){
            return 'e';
        }
        return player1Queue.remove();
    }
    public Character getP2Card(){
        if (player2Queue.isEmpty()){
            return 'e';
        }
        return player2Queue.remove();
    }

    public void giveP1Cards(Character p1Card, Character p2Card){
        player1Queue.add(p1Card);
        player1Queue.add(p2Card);
        System.out.println("Gave p1 cards: " + p1Card + " " + p2Card);
    }
    public void giveP2Cards(Character p1Card, Character p2Card){
        player2Queue.add(p1Card);
        player2Queue.add(p2Card);
        System.out.println("Gave p2 cards: " + p1Card + " " + p2Card);
    }


    public void playGame(){
        int turn = 0;
        while (turn < 107){
            Character p1Card = getP1Card();
            if (Objects.equals(p1Card, 'e')){
                System.out.println("first " + turn );
                return;
            }
            Character p2Card = getP2Card();
            if (Objects.equals(p2Card, 'e')){
                System.out.println("second " + turn );
                return;
            }


            if ((Character.getNumericValue(p1Card) == 0) & (Character.getNumericValue(p2Card) == 9)) {
                System.out.println("p1: 0 beats 9");
                giveP2Cards(p1Card,p2Card);
            } else if ((Character.getNumericValue(p1Card) == 9) & (Character.getNumericValue(p2Card) == 0)) {
                System.out.println("p2: 0 beats 9");
                giveP1Cards(p1Card,p2Card);
            } else if(Character.getNumericValue(p1Card) > Character.getNumericValue(p2Card)){
                giveP2Cards(p1Card,p2Card);
            }  else {
                giveP1Cards(p1Card,p2Card);
            }
            printStacks();
            turn++;
        }
        System.out.println("botva");
        return;
    }
}
