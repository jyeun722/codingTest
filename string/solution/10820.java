import java.util.*;
import java.io.*;

public class Main {
    private static final int PRINT = 4;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String alphabet = "";

        while (sc.hasNext()) {
            alphabet = sc.nextLine();

            int[] result = new int[PRINT];
            String[] replace = {"[a-z]", "[A-Z]", "[0-9]", " "};

            for (int i = PRINT - 1; i >= 0; i--) {
                int len = alphabet.length();
                alphabet = alphabet.replaceAll(replace[i], "");
                result[i] = len - alphabet.length();
            }

            for (int i = 0; i < PRINT; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
