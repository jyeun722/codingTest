import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer input = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[MAX + 1]; // 에라토스테네스의 체 미리 생성 -> 시간 단축
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        while (input != 0) {
            boolean check = false;
            for (int i = input - 3; i * 2 >= input; i -= 2) {
                if (prime[i] && prime[input - i]) {
                    check = true;
                    bw.append(input + " = " + (input - i) + " + " + i + "\n"); // format 보다 + 사용 -> 시간 단축
                    break;
                }
            }
            if (!check) bw.append("Goldbach's conjecture is wrong.\n");

            input = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
    }
}
