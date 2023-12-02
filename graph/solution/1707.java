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
        if (parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    static boolean check = true;

    public static void two(int[] visit, LinkedList<Integer>[] list, int ver, int team) {
        Iterator<Integer> it = list[ver].iterator();
        visit[ver] = team;
        int other = team == 1 ? 2 : 1;

        while (it.hasNext()) {
            int v = it.next();
            if (visit[v] == team) {
                check = false;
                return;
            } else if (visit[v] == 0) {
                two(visit, list, v, other);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Integer>[] list = new LinkedList[n + 1];
            for (int j = 0; j < n + 1; j++) list[j] = new LinkedList<Integer>();

            int[] parent = new int[n + 1];
            for (int j = 1; j < n + 1; j++) parent[j] = j;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list[x].add(y);
                list[y].add(x);

                union(parent, x, y);
            }
            for (int j = 1; j < n + 1; j++) Collections.sort(list[j]);

            HashSet<Integer> set = new HashSet<>();
            for (int j = 1; j < n + 1; j++) {
                set.add(find(parent, j));
            }
            Iterator<Integer> sets = set.iterator();
            int size = set.size();
            for (int j = 0; j < size; j++) {
                int start = sets.next();
                int[] visit = new int[n + 1];
                two(visit, list, start, 1);
            }

            if (check) sb.append("YES\n");
            else sb.append("NO\n");

            check = true;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
