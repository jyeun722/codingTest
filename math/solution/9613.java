import java.util.*;
import java.io.*;

public class Main {
    public static int GCD(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return GCD(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0; // 출력: int 범위 넘을 수 있음 주의
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int big = Math.max(nums[j], nums[k]);
                    int small = Math.min(nums[j], nums[k]);
                    result += GCD(big, small);
                }
            }
            bw.append(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
