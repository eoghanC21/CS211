import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class CheckIfInFile {
    public static void main(String[] args) {
        String word = "zuppa";
        System.out.print(check(word));

    }

    public static boolean check(String word) {

        for (int i = 0; i < 10655; i++) {
            try {
                if (word.equals(Files.readAllLines(Paths.get("allowableWordle.txt")).get(i))) {
                    return true;
                }
            } catch (IOException e) {
            }
        }
        return false;
    }
}
