import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        int K = Integer.parseInt(bufferedReader.readLine());

        int[][] coordinates = new int[K][2];
        for (int h = 0; h < K; h++) {
            String line = bufferedReader.readLine();
            for (int w = 0; w < 2; w++) {
                coordinates[h][w] = Integer.parseInt(line.split(" ")[w]);
            }
        }

        int[][] rectangleCoordinates = new int[4][2];
        int minX = (int)Math.pow(10, 9);
        int maxX = 0;
        int minY = (int)Math.pow(10, 9);
        int maxY = 0;
        for (int h = 0; h < K; h++) {
            if (coordinates[h][0] < minX) minX = coordinates[h][0];
            if (coordinates[h][0] > maxX) maxX = coordinates[h][0];
            if (coordinates[h][1] < minY) minY = coordinates[h][1];
            if (coordinates[h][1] > maxY) maxY = coordinates[h][1];
        }
        rectangleCoordinates[0][0] = minX;
        rectangleCoordinates[0][1] = maxY;

        rectangleCoordinates[1][0] = maxX;
        rectangleCoordinates[1][1] = maxY;

        rectangleCoordinates[2][0] = minX;
        rectangleCoordinates[2][1] = minY;

        rectangleCoordinates[3][0] = maxX;
        rectangleCoordinates[3][1] = minY;

        System.out.println(rectangleCoordinates[2][0] + " " + rectangleCoordinates[2][1] + " " + rectangleCoordinates[1][0] + " " + rectangleCoordinates[1][1]);

    }
}
