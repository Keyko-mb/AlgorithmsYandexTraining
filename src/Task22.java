import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task22 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] dp = new int[N + 1];
        dp[1] = 1;
        int current = 2;
        while (current <= N) {
            if (current > k) {
                for (int i = 1; i <= k; i++) {
                    dp[current] += dp[current - i];
                }
            } else {
                for (int i = 1; i < current; i++) {
                    dp[current] += dp[current - i];
                }
            }
            current++;
        }
        System.out.println(dp[N]);
    }
}
