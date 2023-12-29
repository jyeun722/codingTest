import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        if (!N.contains("0")) sb.append(-1);
        else {
            int sum = 0;
            char[] nums = N.toCharArray();
            for (char c : nums) {
                sum += c - '0';
            }
            if (sum % 3 != 0) sb.append(-1);
            else {
                Arrays.sort(nums);
                String result = new String(nums);
                sb.append(result).reverse();
            }
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
