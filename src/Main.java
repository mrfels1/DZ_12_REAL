import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------Stack Game--------");

        stackGame stackGame = new stackGame("13579","24680");
        stackGame.playGame();

        System.out.println("--------Queue Game--------");

        queueGame queueGame = new queueGame("13579","24680");
        queueGame.playGame();

        System.out.println("--------Dequeue Game--------");

        dequeueGame dequeueGame = new dequeueGame("13579","24680");
        dequeueGame.playGame();

        System.out.println("--------DLL Game--------");

        doublelistGame doublelistGame = new doublelistGame("13579","24680");
        doublelistGame.playGame();

    }

}