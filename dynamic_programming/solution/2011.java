import java.util.*;
import java.io.*;

public class Main {
    private static final int MOD = 1000000;
    private static final int Z = 26;
    private static final int J = 10;

    public static boolean alpha(int x, int y) {
        String ten = "" + x + y;
        int deter = Integer.parseInt(ten);
        if (deter <= Z && deter >= J) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String cipher = st.nextToken();
        int[] nums = Arrays.stream(cipher.split("")).mapToInt(Integer::parseInt).toArray();
        int len = nums.length;

        if (cipher.contains("00") || cipher.startsWith("0")) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[len + 2];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < len + 1; i++) {
            if (nums[i - 1] != 0) { // A(1) ~ i(9)
                dp[i] = dp[i - 1] % MOD;
            }

            if (alpha(nums[i - 2], nums[i - 1])) { // J(10) ~ Z(26)
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[len] % MOD);
    }
}
