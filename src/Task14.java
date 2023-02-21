import java.io.*;
import java.util.*;

public class Task14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<String> values = new ArrayList<>(List.of(bufferedReader.readLine().split(" ")));
        Stack<String> stack = new Stack<>();
        ArrayList<Integer> newValues = new ArrayList<>();
        stack.push(values.get(0));
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && Integer.parseInt(stack.peek()) < Integer.parseInt(values.get(i)))
                newValues.add(Integer.parseInt(stack.pop()));
            stack.push(values.get(i));
        }
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sorted.add(i + 1);
        }
        while (!stack.empty()) newValues.add(Integer.parseInt(stack.pop()));
        if (newValues.equals(sorted)) System.out.println("YES");
        else System.out.println("NO");
    }
}
