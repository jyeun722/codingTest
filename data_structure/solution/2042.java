import java.util.*;
import java.io.*;

public class Main {
    private static long[] tree;
    private static int START = 1;

    private static long init(long[] nums, int node, int start, int end) {
        if (start == end) return tree[node] = nums[start];

        return tree[node] = init(nums, node * 2, start, (start + end) / 2)
                + init(nums, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    private static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;

        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;

        if (left <= start && right >= end) return tree[node];

        return sum(node * 2, start, (start + end) / 2, left, right)
                + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int hei = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int) Math.pow(2, hei);
        tree = new long[size + 1];

        long[] nums = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            long num = Long.parseLong(br.readLine());
            nums[i] = num;
        }
        init(nums, START, START, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());

                long diff = c - nums[b];
                nums[b] = c;
                update(START, START, N, b, diff);
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                long sum = sum(START, START, N, b, c);
                sb.append(sum + "\n");
            }
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
