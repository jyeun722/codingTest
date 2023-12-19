import java.util.*;
import java.io.*;

public class Main {
    private static final int BINARY = -2;
    private static final int FINAL_SHARE = 1;

    public static void divide(ArrayList<Integer> list, int num) {
        int share = num / BINARY;
        if (num % BINARY != 0 && num < 0) share += 1;

        int remain = share * BINARY - num;
        list.add(0, remain);

        if (share == FINAL_SHARE) {
            list.add(0, share);
            return;
        }

        divide(list, share);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n == 0 || n == 1) bw.append(n + "");
        else {
            ArrayList<Integer> list = new ArrayList<>();
            divide(list, n);
            bw.append(list.toString().replaceAll("[^0-1]", ""));
        }

        bw.flush();
        bw.close();
    }
}
