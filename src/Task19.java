import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task19 {
    public static void main(String[] args) throws IOException {
        myHeap heap = new myHeap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            if (line.startsWith("0")) heap.insert(Integer.parseInt(line.split(" ")[1]));
            else if (line.equals("1")) heap.extract();
            else System.out.println("?");
        }
    }
}

class myHeap {
    Integer[] tree = new Integer[100];
    int counter = 0;

    public void insert(int k) {
        if (counter + 1 > tree.length) tree = Arrays.copyOf(tree, tree.length * 10);
        if (counter == 0) {
            tree[0] = k;
        } else {
            int currentIndex = counter - 1;
            tree[++currentIndex] = k;
            int currentParentIndex = (currentIndex - 1) / 2;
            while (currentIndex > 0 && tree[currentParentIndex] < k) {
                tree[currentIndex] = tree[currentParentIndex];
                tree[currentParentIndex] = k;
                currentIndex = currentParentIndex;
                currentParentIndex = (currentIndex - 1) / 2;
            }
        }
        counter++;
    }

    public void extract() {
        System.out.println(tree[0]);
        tree[0] = tree[counter - 1];
        tree[counter-- - 1] = null;
        int currentIndex = 0;
        int child1;
        int child2;
        while (currentIndex < counter) {
            child1 = 2 * currentIndex + 1;
            child2 = 2 * currentIndex + 2;
            if (child1 < counter && child2 < counter) {
                if (tree[child1] > tree[currentIndex] || tree[child2] > tree[currentIndex]) {
                    int temp = tree[currentIndex];
                    if (tree[child1] > tree[child2]) {
                        tree[currentIndex] = tree[child1];
                        tree[child1] = temp;
                        currentIndex = child1;
                    } else {
                        tree[currentIndex] = tree[child2];
                        tree[child2] = temp;
                        currentIndex = child2;
                    }
                } else break;
            } else if (child1 < counter) {
                if (tree[child1] > tree[currentIndex]) {
                    int temp = tree[currentIndex];
                    tree[currentIndex] = tree[child1];
                    tree[child1] = temp;
                    currentIndex = child1;
                } else break;
            } else break;
        }
    }
}