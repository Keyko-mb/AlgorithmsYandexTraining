import java.io.*;
import java.util.*;

public class Task15 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] prices = bufferedReader.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && Integer.parseInt(prices[stack.peek()]) > Integer.parseInt(prices[i])) {
                prices[stack.pop()] = Integer.toString(i);
            }
            stack.push(i);
        }
        while (!stack.empty()) prices[stack.pop()] = "-1";
        for (String elem : prices) System.out.print(elem + " ");
    }
}
