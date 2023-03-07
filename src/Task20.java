import java.io.*;

public class Task20 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] array = bufferedReader.readLine().split(" ");
        myHeap heap = new myHeap();
        for (int i = 0; i < n; i++) {
            heap.insertInTree(Integer.parseInt(array[i]));
        }
        heapify(heap);
        int currentIndex = heap.getCounter() - 1;
        while (currentIndex >= 0) {
            int maxim = heap.extract();
            heap.insertInTreeById(currentIndex--, maxim);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(heap.getTree()[i] + " ");
        }
    }

    public static void heapify(myHeap heap) {
        for (int i = heap.getCounter() - 1; i >= 0; i--)
            if (i * 2 + 1 < heap.getCounter()) {
                sifting(heap, i);
            }
    }

    public static void sifting(myHeap heap, int currentIndex) {
        int child1;
        int child2;
        while (currentIndex < heap.getCounter()) {
            child1 = 2 * currentIndex + 1;
            child2 = 2 * currentIndex + 2;
            if (child1 < heap.getCounter() && child2 < heap.getCounter()) {
                if (heap.getTree()[child1] > heap.getTree()[currentIndex] || heap.getTree()[child2] > heap.getTree()[currentIndex]) {
                    int temp = heap.getTree()[currentIndex];
                    if (heap.getTree()[child1] > heap.getTree()[child2]) {
                        heap.getTree()[currentIndex] = heap.getTree()[child1];
                        heap.getTree()[child1] = temp;
                        currentIndex = child1;
                    } else {
                        heap.getTree()[currentIndex] = heap.getTree()[child2];
                        heap.getTree()[child2] = temp;
                        currentIndex = child2;
                    }
                } else break;
            } else if (child1 < heap.getCounter()) {
                if (heap.getTree()[child1] > heap.getTree()[currentIndex]) {
                    int temp = heap.getTree()[currentIndex];
                    heap.getTree()[currentIndex] = heap.getTree()[child1];
                    heap.getTree()[child1] = temp;
                    currentIndex = child1;
                } else break;
            } else break;
        }
    }
}

