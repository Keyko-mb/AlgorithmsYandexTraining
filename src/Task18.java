import java.io.*;
import java.util.Arrays;

public class Task18 {
    public static void main(String[] args) throws IOException {
        myDeque deque = new myDeque();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = bufferedReader.readLine()).equals("exit")) {
            if (line.startsWith("push_front")) deque.push_front(Integer.parseInt(line.split(" ")[1]));
            else if (line.startsWith("push_back")) deque.push_back(Integer.parseInt(line.split(" ")[1]));
            else if (line.equals("pop_front")) deque.pop_front();
            else if (line.equals("pop_back")) deque.pop_back();
            else if (line.equals("front")) deque.front();
            else if (line.equals("back")) deque.back();
            else if (line.equals("size")) deque.size();
            else if (line.equals("clear")) deque.clear();
            else System.out.println("?");
        }
        deque.exit();
    }
}

class myDeque {
    Integer[] buffer = new Integer[100];
    int front = 0;
    int back = 0;
    int counter = 0;

    public void push_front(int n) {
        if (counter != 0) {
            if (--front < 0) {
                front = 99;
            }
        }
        if (buffer[front] != null) System.out.println("Занято");
        buffer[front] = n;
        counter++;
        System.out.println("ok");
        if (counter == 1) back = front;
    }

    public void push_back(int n) {
        if (counter != 0) {
            if (++back > 99) back = 0;
        }
        if (buffer[back] != null) System.out.println("Занято");
        buffer[back] = n;
        counter++;
        System.out.println("ok");
        if (counter == 1) front = back;
    }

    public void pop_front() {
        if (counter == 0) {
            System.out.println("error");
        } else {
            System.out.println(buffer[front]);
            buffer[front] = null;
            if (++front > 99) front = 0;
            counter--;
        }
    }

    public void pop_back() {
        if (counter == 0) {
            System.out.println("error");
        } else {
            System.out.println(buffer[back]);
            buffer[back] = null;
            if (--back < 0) back = 99;
            counter--;
        }
    }

    public void front() {
        if (counter == 0) {
            System.out.println("error");
        } else System.out.println(buffer[front]);
    }

    public void back() {
        if (counter == 0) {
            System.out.println("error");
        } else System.out.println(buffer[back]);
    }

    public void size() {
        System.out.println(counter);
    }

    public void clear() {
        Arrays.fill(buffer, null);
        front = back = 0;
        counter = 0;
        System.out.println("ok");
    }

    public void exit() {
        System.out.println("bye");
        System.exit(0);
    }
}
