import java.util.*;
import java.io.*;
public class Main {
    public static void dfs(boolean visit[], LinkedList<Integer>[] list, int v) {
        visit[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = list[v].iterator();
        while (it.hasNext()) {
            int ver = it.next();
            if (!visit[ver]) dfs(visit, list, ver);
        }
    }

    public static void bfs(boolean visit[], LinkedList<Integer>[] list, int v) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visit[v] = true;

        while (!que.isEmpty()) {
            int ver = que.poll();
            System.out.print(ver + " ");
            Iterator<Integer> it = list[ver].iterator();

            while (it.hasNext()) {
                int next = it.next();
                if (!visit[next]) {
                    visit[next] = true;
                    que.add(next);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] list = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) list[i] = new LinkedList<Integer>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        for (int i = 1; i < n + 1; i++) Collections.sort(list[i]);

        boolean visit[] = new boolean[n + 1];
        dfs(visit, list, v);
        System.out.println();

        boolean visit2[] = new boolean[n + 1];
        bfs(visit2, list, v); 
    }
}
