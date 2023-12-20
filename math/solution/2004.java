import java.util.*;
import java.io.*;

public class Main {
    private static final int FIVE = 5;
    private static final int TWO = 2;

    public static int count(int num, int divide) {
        // 2, 5 각각 배수마다 하나씩 추가
        int cnt = 0;
        for (long i = divide; i <= num; i *= divide) { // i *= divide -> i 범위 주의
            cnt += num / i;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int nm = n - m;

        int five = count(n, FIVE) - count(m, FIVE) - count(nm, FIVE);
        int two = count(n, TWO) - count(m, TWO) - count(nm, TWO);

        bw.append(Math.min(two, five) + "");
        bw.flush();
        bw.close();
    }
}
