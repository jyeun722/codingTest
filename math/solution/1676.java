import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 5; i <= n; i += 5) {
            int tmp = i;
            while (tmp % 5 == 0) { // 5 -> 10의 배수 판별기
                tmp /= 5;
                cnt++;
            }
        }

        bw.append(cnt + "");
        bw.flush();
        bw.close();
    }
}
