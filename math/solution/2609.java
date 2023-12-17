import java.util.*;
import java.io.*;

public class Main {
    // a, b(a > b)
    // a = bq + r(0 <= r < b)
    // => a: b, b: r 넣고 반복
    public static int GCD(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return GCD(y, x % y);
    }

    // LCD = 두 수 * GCD
    public static int LCD(int x, int y) {
        return x * y / GCD(x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int big = Math.max(num1, num2);
        int small = Math.min(num1, num2);

        int gcd = GCD(big, small);
        int lcd = LCD(big, small);

        bw.append(gcd + "\n" + lcd);
        bw.flush();
        bw.close();
    }
}
