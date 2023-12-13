import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] P = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
                // dp[4] = dp[0](0개 샀을 때) + P[4]
                // dp[4] = dp[1] + P[3]
                // dp[4] = dp[2] + P[2] ..
            }
        }

        System.out.println(dp[N]);
    }
}
