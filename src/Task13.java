import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split(" ");
        Stack<String> stack = new Stack<>();
        String operation = "+-*";
        for (String symbol : line) {
            if (!operation.contains(symbol)) {
                stack.push(symbol);
            } else {
                int top = (Integer.parseInt(stack.pop()));
                int low = (Integer.parseInt(stack.pop()));
                switch (symbol) {
                    case "+" -> stack.push(Integer.toString(top + low));
                    case "-" -> stack.push(Integer.toString(low - top));
                    case "*" -> stack.push(Integer.toString(top * low));
                    default -> System.out.println("?");
                }
            }
        }
        System.out.println(stack.pop());
    }
}
