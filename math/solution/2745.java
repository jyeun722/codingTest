import java.util.*;
import java.io.*;

public class Main {
    private static final int ALPHA = 10;
    private static final int TO_NUMBER = 55;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        long result = 0;

        if (b < ALPHA) {
            long[] nums = Arrays.stream(n.split("")).mapToLong(Long::parseLong).toArray();
            for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
                result += nums[i] * Math.pow(b, j);
            }
        } else if (b > ALPHA) {
            char[] nums = n.toCharArray();
            for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
                int pow = Character.isDigit(nums[i]) ? Character.getNumericValue(nums[i]) : Character.toUpperCase(nums[i]) - TO_NUMBER;
                result += pow * Math.pow(b, j);
            }
        } else {
            result = Long.parseLong(n);
        }

        bw.append(result + "\n");
        bw.flush();
        bw.close();
    }
}
