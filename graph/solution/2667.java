import java.util.*;
import java.io.*;

public class Main {
    private static int[][] house;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static int dfs(int row, int col, int size, int count) {
        if (house[row][col] == 1) {
            count++;
            house[row][col] = 0;
        } else return count;

        for (int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if (x <= size && y <= size) {
                count = dfs(x, y, size, count);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        house = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            String[] line = br.readLine().split("");

            for (int j = 1; j < N + 1; j++) {
                house[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (house[i][j] == 1) {
                    int result = dfs(i, j, N, 0);
                    results.add(result);
                }
            }
        }

        Collections.sort(results);
        sb.append(results.size() + "\n");
        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i) + "\n");
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
