//Grey dupliction when letter is inputed in wrong place more than once while it hasnt been inputted in right place ever

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordleLogic {
    static String mysteryWord = "";
    static char[] mysteryWordar = new char[5];
    static char[] guessar = new char[5];
    static String res = "";
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 6; // index in word list
        try {
            mysteryWord = (Files.readAllLines(Paths.get("wordleWords.txt")).get(x).toUpperCase());

            mysteryWordar = (Files.readAllLines(Paths.get("wordleWords.txt")).get(x).toUpperCase()).toCharArray();
        } catch (IOException e) {
        }

        int g = 1;
        while (g <= 6 & found == false) {
            System.out.println("Guess " + g + ": ");
            String guess = sc.nextLine().toUpperCase();
            System.out.println(guessCheck(mysteryWordar, guess));
            g++;
        }
        sc.close();
    }

    public static String guessCheck(char[] wordar, String guess) {
        guessar = guess.toCharArray();
        res = "";
        String temp;
        for (int i = 0; i < 5; i++) {
            if (mysteryWordar[i] == guessar[i]) {
                res += mysteryWordar[i];
            } else if (yellowCheck2(wordar, guessar[i]) == true
                    && yellowCheck2(res.toCharArray(), guessar[i]) == false) {
                res += String.valueOf(guessar[i]).toLowerCase();
            } else {
                res += "_";
            }

        }

        if (res.equals(mysteryWord)) {
            found = true;
            res += " *This is the correct word!*";
        }

        /*
         * else if (res.equals("     ")) {
         * yellowCheck(wordar, guess);
         * return ("No letters positioned correctly");
         * }
         * 
         * yellowCheck(wordar, guess);
         */
        return res;
    }

    public static void yellowCheck(char[] wordar, String guess) {
        guessar = guess.toCharArray();
        String wrongPos = "";
        char current = 'x';
        for (int i = 0; i < 5; i++) {
            current = guessar[i];
            for (int j = 0; j < 5; j++) {
                if (current == mysteryWordar[j] && i != j) {
                    wrongPos += current + " ";
                }
            }
        }
        if (wrongPos.equals("") == false) {
            System.out.println(
                    "The following letters are in the mystery word but placed incorrectly " + wrongPos.toUpperCase());
        }
    }

    public static boolean yellowCheck2(char[] wordar, char letter) {
        boolean present = false;
        for (int i = 0; i < wordar.length; i++) {
            if (wordar[i] == letter) {
                present = true;
                return present;
            }
        }
        return present;
    }
}
