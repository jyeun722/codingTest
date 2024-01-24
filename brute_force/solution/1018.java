import java.util.*;
import java.io.*;

public class Main {
    static char[][] chess;
    static int LINE = 8;
    static int MAX_VALUE = 64;

    static int count(int x, int y) {
        int cnt = 0;
        char cur = 'B';
        for (int i = x; i < x + LINE; i++) {
            for (int j = y; j < y + LINE; j++) {
                if (chess[i][j] == cur) {
                    cnt++;
                }
                cur = cur == 'B' ? 'W' : 'B';
            }
            cur = cur == 'B' ? 'W' : 'B';
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chess = new char[N][M];
        for (int i = 0; i < N; i++) {
            String status = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = status.charAt(j);
            }
        }

        int min = N * M;
        for (int i = 0; i <= N - LINE; i++) {
            for (int j = 0; j <= M - LINE; j++) {
                int cnt = count(i, j);
                int cntMin = Math.min(cnt, MAX_VALUE - cnt);
                min = Math.min(cntMin, min);
            }
        }

        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
