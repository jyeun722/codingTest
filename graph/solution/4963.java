import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = {0, 1, 0, -1, -1, -1, 1, 1};
    private static int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};

    public static int dfs(int[][] map, int row, int col, int count, int rowSize, int colSize) {
        if (map[row][col] == 1) {
            count++;
            map[row][col] = 0;
        } else return count;

        for (int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if (x <= rowSize && y <= colSize) {
                count = dfs(map, x, y, count, rowSize, colSize);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            int[][] map = new int[h + 1][w + 1];

            for (int i = 1; i < h + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < w + 1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    if (map[i][j] == 1) {
                        int result = dfs(map, i, j, 0, h, w);
                        if (result != 0) count++;
                    }

                }
            }

            sb.append(count + "\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
