import java.util.*;
import java.io.*;
public class Main {
    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int[] parent, int x) {
        if (x == parent[x]) return x;
        else return find(parent, parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] parent = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                parent[j] = j;
            }

            for (int j = 1; j < n + 1; j++) {
                int v = Integer.parseInt(st.nextToken());
                union(parent, j, v);
            }

            HashSet<Integer> set = new HashSet<>();
            for (int j = 1; j < n + 1; j++) {
                set.add(find(parent, j));
            }
            System.out.println(set.size());
        }
    }
}
