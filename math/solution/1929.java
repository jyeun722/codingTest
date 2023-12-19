import java.util.*;
import java.io.*;

// 에라토스테네스의 체 구현
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if (n == 1) return;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[1] = false; // 1은 소수 아님

        for (int i = 2; i * i <= n; i++) { // 절반까지 확인
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false; // i의 배수 삭제
                }
            }
        }

        for (int i = m; i < prime.length; i++) {
            if (prime[i]) bw.append(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}
