import java.util.*;
import java.io.*;

public class Main {
    private static final int ALPHA = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String alphabet = st.nextToken();

        int[] result = new int[ALPHA];
        Arrays.fill(result, -1);

        int idx = 0;
        for (char alpha : alphabet.toCharArray()) {
            int index = Character.getNumericValue(alpha) - 10;
            result[index] = result[index] == -1 ? idx : result[index];

            idx++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
