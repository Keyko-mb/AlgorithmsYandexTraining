import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task9 {
    public static int[] parseMassToInt(String[] mass) {
        int[] intMass = new int[mass.length];
        for (int i = 0; i < mass.length; i++) {
            intMass[i] = Integer.parseInt(mass[i]);
        }
        return intMass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        int[] firstLine = parseMassToInt(bufferedReader.readLine().split(" "));
        int N = firstLine[0];
        int M = firstLine[1];
        int K = firstLine[2];

        int[][] matrix = new int[N][M];
        int[] line;
        for (int row = 0; row < N; row++) {
            line = parseMassToInt(bufferedReader.readLine().split(" "));
            System.arraycopy(line, 0, matrix[row], 0, M);
        }

        int[][] sumCoordinates = new int[K][4];
        for (int row = 0; row < K; row++) {
            line = parseMassToInt(bufferedReader.readLine().split(" "));
            System.arraycopy(line, 0, sumCoordinates[row], 0, 4);
        }

        int[][] sumMatrix = matrix.clone();
        for (int row = 1; row < N; row++) {
            sumMatrix[row][0] += sumMatrix[row - 1][0];
        }
        for (int column = 1; column < M; column++) {
            sumMatrix[0][column] += sumMatrix[0][column - 1];
        }
        for (int row = 1; row < N; row++) {
            for (int column = 1; column < M; column++) {
                sumMatrix[row][column] += sumMatrix[row - 1][column] + sumMatrix[row][column - 1] - sumMatrix[row - 1][column - 1];
            }
        }

        int x1, x2, y1, y2;
        int sum;
        for (int r = 0; r < K; r++) {
            x1 = sumCoordinates[r][0] - 1;
            y1 = sumCoordinates[r][1] - 1;

            x2 = sumCoordinates[r][2] - 1;
            y2 = sumCoordinates[r][3] - 1;

            sum = sumMatrix[x2][y2];

            if (x1 == 0 && y2 == 0) {
                System.out.println(sum);
                continue;
            }

            if (x1 > 0) sum -= sumMatrix[x1 - 1][y2];
            if (y1 > 0) sum -= sumMatrix[x2][y1 - 1];
            if (x1 > 0 && y1 > 0) sum += sumMatrix[x1 - 1][y1 - 1];

            System.out.println(sum);
        }
    }
}
