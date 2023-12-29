import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        if (N == 1) count++;
        else if (N == 2) {
            count = Math.min(4, (M - 1) / 2 + 1);
            // 4: 초기점 + 2번 이동 + 1번 이동(제약 사항)
        } else {
            if (M >= 7) count += M - 2;
            else count = Math.min(4, M);
            // 4: 초기점 + 2번 이동 + 1번 이동(제약 사항)
        }

        sb.append(count);

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
