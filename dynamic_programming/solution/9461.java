import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Long> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N <= 3) {
                result.add(Long.valueOf(1));
            } else if (N <= 5) {
                result.add(Long.valueOf(2));
            } else {
                long[] dp = new long[N];
                Arrays.fill(dp, 1);
                dp[3] = 2;
                dp[4] = 2;
                for (int j = 5; j < N; j++) {
                    dp[j] = dp[j - 1] + dp[j - 5];
                }
                result.add(dp[N - 1]);
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result.get(i));
        }
    }
}
