import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task12 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        char current;
        boolean flag = true;
        if (!line.isEmpty()) {
            for (Character bracket : line.toCharArray()) {
                if (bracket == ')' || bracket == '}' || bracket == ']') {
                    if (stack.empty()) {
                        flag = false;
                        break;
                    }
                    current = stack.peek();
                    if (current == ')' || current == '}' || current == ']') {
                        flag = false;
                        break;
                    }
                    if (bracket == ')') {
                        if (current != '(') {
                            flag = false;
                            break;
                        } else stack.pop();
                    }
                    if (bracket == '}') {
                        if (current != '{') {
                            flag = false;
                            break;
                        } else stack.pop();
                    }
                    if (bracket == ']') {
                        if (current != '[') {
                            flag = false;
                            break;
                        } else stack.pop();
                    }
                } else {
                    stack.push(bracket);
                }
            }
        }
        if (!stack.empty()) flag = false;
        if (flag) System.out.println("yes");
        else System.out.println("no");
    }
}
