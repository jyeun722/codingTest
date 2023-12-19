import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean check = true;
            for (int j = 2; j * j <= num; j++) { // 곱이 절반 기준으로 대칭
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }

            if (num == 1) check = false;
            if (check) result++;
        }

        bw.append(result + "");
        bw.flush();
        bw.close();
    }
}
