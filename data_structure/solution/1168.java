import java.util.*;
import java.io.*;

public class Main {
    private static int[] tree;
    private static int START = 1;

    private static int init(int node, int start, int end) {
        if (start == end) return tree[node] = START;

        return tree[node] = init(node * 2, start, (start + end) / 2)
                + init(node * 2 + 1, (start + end) / 2 + 1, end);
    }

    private static void update(int node, int start, int end, int idx) {
        if (idx < start || idx > end) return;

        tree[node]--;

        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx);
        }
    }

    private static int order(int node, int start, int end, int val) {
        if (start == end) return start;

        if (val <= tree[node * 2]) return order(node * 2, start, (start + end) / 2, val);
        else return order(node * 2 + 1, (start + end) / 2 + 1, end, val - tree[node * 2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int hei = (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1);
        int size = (int) Math.pow(2, hei);
        tree = new int[size + 1];

        init(START, START, N);

        int index = 1;
        for (int i = 0; i < N; i++) {
            index = (index + K - 2) % (N - i) + 1;
            // 4(index + K - 1) % 4(size) = 4

            int find = order(START, START, N, index);
            update(START, START, N, find);

            sb.append(find + ", ");
        }

        String str = sb.toString();
        String result = "<" + str.substring(0, str.length() - 2) + ">";
        bw.append(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
