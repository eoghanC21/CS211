import java.util.Scanner;

public class Wordle {
    private static final String ANSWER = "BEARD";// FileReader.getInputAsArrayList("words.txt")
    // .get((int) Math.floor(Math.random() * 212)).toUpperCase();
    private static String guess = "";

    public static void main(String[] args) {
        play(6);
    }

    public static void play(int guesses) {
        try (Scanner input = new Scanner(System.in)) {
            for (int i = 1; i <= guesses; i++) { // For every guess
                guess = "";
                String[] output = { "", "", "", "", "" };

                System.out.println("Enter your guess for a five letter word: ");
                while (guess.length() != 5)
                    guess = input.nextLine().toUpperCase();

                if (guess.equals(ANSWER)) {
                    System.out.println(
                            "* * * * *\nYou win! You guessed the word \"" + ANSWER + "\" in " + i + " guesses.");
                    return;
                }

                String fizzle = ANSWER; // This took an unreasonable amount of time to make
                for (int j = 0; j < 5; j++) {
                    String g = guess.substring(j, j + 1);
                    String a = ANSWER.substring(j, j + 1);
                    if (g.equals(a)) {
                        output[j] = "* ";
                        fizzle = fizzle.substring(0, j) + "_" + fizzle.substring(j + 1);
                    }
                }
                for (int j = 0; j < 5; j++) {
                    String g = guess.substring(j, j + 1);

                    while (fizzle.contains(g)) {
                        if (!output[j].equals(""))
                            break;

                        output[j] = "~ ";
                        fizzle = fizzle.substring(0, fizzle.indexOf(g)) + "_" + fizzle.substring(fizzle.indexOf(g) + 1);
                    }
                    if (output[j].equals(""))
                        output[j] = "_ ";
                }
                for (String s : output)
                    System.out.print(s);
                System.out.println();
            }
            System.out.println("You lose! You could not guess the word \"" + ANSWER + "\" in " + guesses + " guesses.");
        }
    }
}