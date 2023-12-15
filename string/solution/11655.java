import java.io.*;

public class Main {
    private static final int UPPER_START = 65;
    private static final int UPPER_END = 90;
    private static final int LOWER_START = 97;
    private static final int LOWER_END = 122;
    private static final int ROT = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alphabet = br.readLine();
        for (char alpha : alphabet.toCharArray()) {
            int idx = (int) alpha + ROT;
            if (alpha == ' ' || (alpha >= 48 && alpha <= 57)) {
                System.out.print(alpha);
                continue;
            }

            if (idx > LOWER_END) {
                System.out.print((char) (idx % LOWER_END + LOWER_START - 1));
            } else if (idx > UPPER_END && idx <= UPPER_END + ROT) {
                System.out.print((char) (idx % UPPER_END + UPPER_START - 1));
            } else {
                System.out.print((char) idx);
            }
        }
    }
}
