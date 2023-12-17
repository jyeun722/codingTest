import java.util.*;
import java.io.*;

public class Main {
    public static long GCD(long x, long y) {
        if (x % y == 0) {
            return y;
        }
        return GCD(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        long big = Math.max(num1, num2);
        long small = Math.min(num1, num2);

        long gcd = GCD(big, small);

        for (int i = 0; i < gcd; i++) {
            bw.append("1");
        }
        bw.flush();
        bw.close();
    }
}
