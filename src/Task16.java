import java.io.*;
import java.util.Arrays;

public class Task16 {
    public static void main(String[] args) throws IOException {
        myQueue queue = new myQueue();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = bufferedReader.readLine()).equals("exit")) {
            if (line.startsWith("push")) queue.push(Integer.parseInt(line.split(" ")[1]));
            else if (line.equals("pop")) queue.pop();
            else if (line.equals("front")) queue.front();
            else if (line.equals("size")) queue.size();
            else if (line.equals("clear")) queue.clear();
            else System.out.println("?");
        }
        queue.exit();
    }
}

class myQueue {
    Integer[] queue = new Integer[100];
    int head;
    int tail;

    public void push(int n) {
        if (tail + 1 >= queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 10);
        }
        queue[tail++] = n;
        System.out.println("ok");
    }

    public void pop() {
        if (tail == head) {
            System.out.println("error");
        } else {
            System.out.println(queue[head]);
            queue[head++] = null;
        }
    }

    public void front() {
        if (tail == head) {
            System.out.println("error");
        } else {
            System.out.println(queue[head]);
        }
    }

    public void size() {
        System.out.println(tail - head);
    }

    public void clear() {
        Arrays.fill(queue, null);
        head = tail = 0;
        System.out.println("ok");
    }

    public void exit() {
        System.out.println("bye");
        System.exit(0);
    }
}