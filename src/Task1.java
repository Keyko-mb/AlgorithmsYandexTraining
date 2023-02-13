import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> letters = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        int t;
        while ((t = fileInputStream.read()) != -1) {
            letters.add(Character.toString((char) t));
        }

        SortedMap<Character, Integer> map = new TreeMap<>();
        for (String letter : letters) {
            if ((letter.equals(" ")) || (letter.equals("\n"))) continue;
            map.put(letter.charAt(0), 0);
        }
        for (Character key : map.keySet()) {
            int k = 0;
            for (String letter : letters) {
                if (key == letter.charAt(0)) {
                    k += 1;
                }
            }
            map.put(key, k);
        }

        int maxHeight = Collections.max(map.values());
        int matrixHeight = maxHeight + 1;
        int matrixWidth = map.keySet().size();
        Character[][] result = new Character[matrixHeight][matrixWidth];

        for (int width = 0; width < matrixWidth; width++) {
            Character currentChar = map.firstKey();
            for (int height = 0; height < matrixHeight; height++) {
                if (height + 1 == matrixHeight) {
                    result[height][width] = currentChar;
                    break;
                }
                if (maxHeight - height <= map.get(currentChar))
                    result[height][width] = '#';
                else result[height][width] = ' ';
            }
            map.remove(currentChar);
        }

        for (int i = 0; i < matrixHeight; i++) {
            for (int q = 0; q < matrixWidth; q++) {
                System.out.print(result[i][q]);
            }
            if (i + 1 != matrixHeight)
                System.out.println();
        }
    }
}