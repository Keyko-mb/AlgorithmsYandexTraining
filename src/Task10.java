import java.util.*;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int[] letters = new int[26];

        String combination;
        int n = line.length();

        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                combination = line.substring(i, k + 1);
                int n2 = combination.length();
                for (int m = 0; m < n2; m++) {
                    letters[combination.charAt(m) - 'a']++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                System.out.println((char) ('a' + i) + ": " + letters[i]);
            }
        }
    }

//2 решение
//        String[] combinations = new String[(line.length() * (line.length() + 1)) / 2];
//        int id = 0;
//        for (int i = 0; i < line.length(); i++) {
//            for (int k = i; k < line.length(); k++) {
//                combinations[id] = line.substring(i, k + 1);
//                id++;
//            }
//        }
//
//        int[] letters = new int[26];
//        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//
//        for (String combination : combinations) {
//            for (int i = 0; i < combination.length(); i++) {
//                for (int q = 0; q < 26; q++) {
//                    if (combination.charAt(i) == alphabet[q])
//                        letters[q] += 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < 26; i++) {
//            if (letters[i] != 0) {
//                System.out.println(alphabet[i] + ": " + letters[i]);
//            }
//        }

//1 решение
//        Map<Character, Integer> letters = new HashMap<>();
//        for (int i = 0; i < line.length(); i++) {
//            letters.put(line.charAt(i), 0);
//        }
//
//        for (String combination : combinations) {
//            for (int q = 0; q < combination.length(); q++) {
//                Character current = combination.charAt(q);
//                if (letters.containsKey(current)) {
//                    int k = letters.get(current);
//                    k += 1;
//                    letters.put(current, k);
//                }
//            }
//        }
//
//        Map<Character, Integer> sortedLetters = new TreeMap<>(letters);
//
//        for (var pair : sortedLetters.entrySet()) {
//            System.out.println(pair.getKey() + ": " + pair.getValue());
//        }
}

