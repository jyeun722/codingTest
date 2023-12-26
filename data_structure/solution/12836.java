import java.util.*;
import java.io.*;

public class Main {
    private static long[] tree;

    private static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return; // 리프노드 가지치기

        tree[node] += diff;

        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;

        if (start >= left && end <= right) return tree[node];

        return sum(node * 2, start, (start + end) / 2, left, right)
                + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int hei = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1; // 트리 높이
        int size = (int) Math.pow(2, hei);
        tree = new long[size + 1];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int day = Integer.parseInt(st.nextToken());
                int money = Integer.parseInt(st.nextToken());

                update(1, 1, n, day, money);
            } else if (order == 2) {
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                long sum = sum(1, 1, n, p, q);
                sb.append(sum + "\n");
            }
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
