import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meeting[i] = new int[]{start, end};
        }

        Arrays.sort(meeting, (i1, i2) -> {
            return i1[1] != i2[1] ? i1[1] - i2[1] : i1[0] - i2[0];
        });

        int end = -1, result = 0;
        for (int i = 0; i < meeting.length; i++) {
            if (meeting[i][0] >= end) {
                result++;
                end = meeting[i][1];
            }
        }

        bw.append(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
