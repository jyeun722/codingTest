import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] times = new int[N];
        for (int i = 1; i < N + 1; i++) {
            int time = Integer.parseInt(st.nextToken());
            times[i - 1] = time;
        }
        Arrays.sort(times);
        int result = 0, present = 0;
        for (int i = 0; i < times.length; i++) {
            present = present + times[i];
            result += present;
        }

        bw.append(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
