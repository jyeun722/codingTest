import java.util.*;
import java.io.*;

public class Main {
    public static int GCD(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return GCD(y, x % y);
    }

    public static int LCD(int x, int y) {
        return x * y / GCD(x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            bw.append(LCD(num1, num2) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
