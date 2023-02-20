import java.io.*;

public class Task11 {
    public static void main(String[] args) throws IOException {
        Stack11 stack = new Stack11();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String command;
        do {
            command = scanner.readLine();
            if (command.startsWith("push")) stack.push(Integer.parseInt(command.split(" ")[1]));
            else if (command.startsWith("pop")) stack.pop();
            else if (command.startsWith("back")) stack.back();
            else if (command.startsWith("size")) stack.size();
            else if (command.startsWith("clear")) stack.clear();
            else if (command.startsWith("exit")) stack.exit();
            else System.out.println("такой команды нет");
        } while (!command.equals("exit"));
    }
}

class Stack11 {
    private Integer[] list;
    private int last;

    public Stack11() {
        list = new Integer[100];
        last = -1;
    }

    public Integer[] getList() {
        return list;
    }

    public void setList(Integer[] list) {
        this.list = list;
    }

    public void push(int n) {
        if (last + 1 >= list.length) {
            Integer[] current = list.clone();
            Integer[] newList;
            if (list.length == 0) {
                newList = new Integer[1];
            } else {
                newList = new Integer[list.length * 2];
            }
            setList(newList);
            System.arraycopy(current, 0, list, 0, current.length);
        }
        list[++last] = n;
        System.out.println("ok");
    }

    public void pop() {
        if (last >= 0) {
            System.out.println(list[last]);
            list[last] = null;
            last--;
        } else System.out.println("error");
    }

    public void back() {
        if (last >= 0) {
            System.out.println(list[last]);
        } else {
            System.out.println("error");
        }
    }

    public void size() {
        System.out.println(last + 1);
    }

    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
        last = -1;
        System.out.println("ok");
    }

    public void exit() {
        System.out.println("bye");
        System.exit(0);
    }
}


