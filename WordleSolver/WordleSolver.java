import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleSolver {

    private static ArrayList<String> arlt;
    private static String greenUsed = "";
    private static String yellowUsed = "";

    public static void main(String[] args) throws FileNotFoundException {

        arlt = new ArrayList<String>();
        File wordleWords = new File("wordleWords.txt");
        Scanner readin = new Scanner(wordleWords);
        while (readin.hasNextLine()) {
            arlt.add(readin.next());
        }
        readin.close();
        Scanner sc = new Scanner(System.in);
        String[] guessAr = new String[6];
        String[] feedbackAr = new String[6];
        guessAr[0] = "crane";
        System.out.println("Input 2 for green, 1 for yellow, and 0 for grey, with no spaces between numbers");
        System.out.println("Guess 1: " + guessAr[0].toUpperCase() + "\nFeedback recieved: ");
        feedbackAr[0] = sc.next();
        updateManager(guessAr[0], feedbackAr[0]);

        for (int i = 1; i < 6; i++) {
            guessAr[i] = arlt.get(0);
            if (arlt.size() == 1) {
                System.out.println("The answer is: " + arlt.get(0).toUpperCase());
                break;
            }
            System.out.println("Guess " + (i + 1) + ": " + arlt.get(0).toUpperCase() + "\nFeedback recieved: ");
            feedbackAr[i] = sc.next();
            if (feedbackAr[i].length() != 5) {
                System.out.println("Invalid");
                i--;
            } else if (feedbackAr[i].equals("22222")) {
                System.out.println("Guess " + (i + 1) + "/6 correct");
                break;
            } else {
                arlt.remove(0);
                updateManager(guessAr[i], feedbackAr[i]);
            }
        }

    }

    public static void updateManager(String guess, String feedback) {
        for (int i = 0; i < 5; i++) {
            if (feedback.substring(i, i + 1).equals("2")) {
                greenFileUpdate(guess.substring(i, i + 1), i);
                // System.out.println("Green updating with: " + guess.substring(i, i + 1) + " at
                // position: "
                // + feedback.substring(i, i + 1));
            } else if (feedback.substring(i, i + 1).equals("1")) {
                yellowFileUpdate(guess.substring(i, i + 1), i);
            } else {
                greyFileUpdate(guess.substring(i, i + 1), i);
                // System.out.println("Grey updating with: " + guess.substring(i, i + 1));
            }
        }
    }

    public static void greyFileUpdate(String letter, int pos) {
        String regex;
        for (int i = 0; i < greenUsed.length(); i++) {
            if (letter.equals(greenUsed.substring(i, i + 1))) {
                regex = ".*".concat(letter).concat(letter).concat(".*");
                for (int j = 0; j < arlt.size(); j++) {
                    if (arlt.get(j).matches(regex)) {
                        arlt.remove(j);
                        i--;
                    }
                }
                return;
            }
        }
        for (int i = 0; i < yellowUsed.length(); i++) {
            if (letter.equals(yellowUsed.substring(i, i + 1))) {
                regex = ".*".concat(letter).concat(letter).concat(".*");
                for (int j = 0; j < arlt.size(); j++) {
                    if (arlt.get(j).matches(regex)) {
                        arlt.remove(j);
                        i--;
                    }
                }
                return;
            }
        }
        for (int i = 0; i < arlt.size(); i++) {
            if (arlt.get(i).contains(letter)) { // should check if grey letter has been green/yellow in the past to deal
                                                // with duplication
                arlt.remove(i);
                i--;
            }
        }
    }

    public static void yellowFileUpdate(String letter, int pos) {
        yellowUsed += letter;
        String regex;
        if (pos == 0) {
            regex = letter.concat("....");
        } else if (pos == 1) {
            regex = ".".concat(letter.concat("..."));
        } else if (pos == 2) {
            regex = "..".concat(letter.concat(".."));
        } else if (pos == 3) {
            regex = "...".concat(letter.concat("."));
        } else {
            regex = "....".concat(letter);
        }
        for (int i = 0; i < arlt.size(); i++) {
            if (arlt.get(i).matches(regex) == true || arlt.get(i).contains(letter) == false) {
                arlt.remove(i);
                i--;
            }
        }
    }

    public static void greenFileUpdate(String letter, int pos) {
        greenUsed += letter;
        String regex;
        if (pos == 0) {
            regex = letter.concat("....");
        } else if (pos == 1) {
            regex = ".".concat(letter.concat("..."));
        } else if (pos == 2) {
            regex = "..".concat(letter.concat(".."));
        } else if (pos == 3) {
            regex = "...".concat(letter.concat("."));
        } else {
            regex = "....".concat(letter);
        }
        for (int i = 0; i < arlt.size(); i++) {
            if (arlt.get(i).matches(regex) == false) {
                arlt.remove(i);
                i--;
            }
        }
    }
}
