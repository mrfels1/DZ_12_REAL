import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class stackGame {
    public Stack<String> player1Stack;
    public Stack<String> player2Stack;

    public stackGame(String player1str, String player2str){
        this.player1Stack = new Stack<String>();
        this.player2Stack = new Stack<String>();
        for (int i = player1str.length(); i > 0; i--) {
            this.player1Stack.push(player1str.substring(i-1,i));
        }
        System.out.println();
        for (int i = player2str.length(); i > 0; i--) {
            this.player2Stack.push(player2str.substring(i-1,i));
        }
    }
    public void printStacks(){
        System.out.println(Arrays.toString(player1Stack.toArray()));
        System.out.println();
        System.out.println(Arrays.toString(player2Stack.toArray()));
    }
    public String getP1Card(){
        if (player1Stack.empty()){
            return "empty";
        }
        return player1Stack.pop();
    }
    public String getP2Card(){
        if (player2Stack.empty()){
            return "empty";
        }
        return player2Stack.pop();
    }
    public void giveP1Cards(String p1Card, String p2Card){
        Stack<String> tempStack = new Stack<String>();
        //System.out.println("p1stack" + Arrays.toString(player1Stack.toArray()));
        int psize = player1Stack.size();
        for(int i = 0; i < psize; i++){
            tempStack.push(player1Stack.pop());
        }
        //System.out.println("Tempstack" + Arrays.toString(tempStack.toArray()));
        tempStack.push(p1Card);
        tempStack.push(p2Card);
        //System.out.println("Tempstack" + Arrays.toString(tempStack.toArray()));
        int tsize = tempStack.size();
        for(int i = 0; i < tsize; i++){
            player1Stack.push(tempStack.pop());
        }
        System.out.println("Gave p1 cards: " + p1Card + " " + p2Card);
        System.out.println();
    }
    public void giveP2Cards(String p1Card, String p2Card){
        Stack<String> tempStack = new Stack<String>();
        int psize = player2Stack.size();
        for(int i = 0; i < psize; i++){
            tempStack.push(player2Stack.pop());
        }
        tempStack.push(p1Card);
        tempStack.push(p2Card);
        int tsize = tempStack.size();
        for(int i = 0; i < tsize; i++){
            player2Stack.push(tempStack.pop());
        }
        System.out.println("Gave p2 cards: " + p1Card + " " + p2Card);
    }

    public void playGame(){
        int turn = 0;
        while (turn < 107){
            String p1Card = getP1Card();
            if (Objects.equals(p1Card, "empty")){
                System.out.println("first " + turn );
                return;
            }
            String p2Card = getP2Card();
            if (Objects.equals(p2Card, "empty")){
                System.out.println("second " + turn );
                return;
            }
            if ((Integer.parseInt(p1Card) == 0) & (Integer.parseInt(p2Card) == 9)) {
                System.out.println("p1: 0 beats 9");
                giveP2Cards(p1Card,p2Card);
            } else if ((Integer.parseInt(p1Card) == 9) & (Integer.parseInt(p2Card) == 0)) {
                System.out.println("p2: 0 beats 9");
                giveP1Cards(p1Card,p2Card);
            } else if(Integer.parseInt(p1Card) > Integer.parseInt(p2Card)){
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
