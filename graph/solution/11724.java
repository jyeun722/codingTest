import java.util.*;
import java.io.*;
public class Main {
    public static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);

        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    public static int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        else return find(parent[x], parent);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y, parent);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            set.add(find(i, parent));
        }
        System.out.println(set.size());
    }
}
