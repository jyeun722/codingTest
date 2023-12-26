import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> scores = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores.put(score, i);
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(i - scores.get(i) + "\n");
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
