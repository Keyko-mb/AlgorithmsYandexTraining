import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task21 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i < 4) {
                if (i == 1) array[1] = 2;
                else if (i == 2) array[2] = 4;
                else if (i == 3) array[3] = 7;
                if (N == i) break;
            } else array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        System.out.println(array[N]);
    }
}
