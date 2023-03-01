import java.io.*;
import java.util.*;

public class Task17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> player1 = new LinkedList<>();
        for (String number : bufferedReader.readLine().split(" ")) {
            player1.add(Integer.valueOf(number));
        }

        Queue<Integer> player2 = new LinkedList<>();
        for (String number : bufferedReader.readLine().split(" ")) {
            player2.add(Integer.valueOf(number));
        }

        boolean firstIsAWinner = false;
        int k = 0;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            if (++k > Math.pow(10, 6)) {
                System.out.println("botva");
                System.exit(0);
            }

            int card1 = player1.remove();
            int card2 = player2.remove();

            if (card1 == 0 && card2 == 9) firstIsAWinner = true;
            else if (card1 == 9 && card2 == 0) firstIsAWinner = false;
            else if (card1 > card2) {
                firstIsAWinner = true;
            } else if (card2 > card1) {
                firstIsAWinner = false;
            } else System.out.println("?");

            if (firstIsAWinner) {
                player1.add(card1);
                player1.add(card2);
            } else {
                player2.add(card1);
                player2.add(card2);
            }
        }
        if (player1.isEmpty()) System.out.print("second " + k);
        else System.out.print("first " + k);
    }
}
