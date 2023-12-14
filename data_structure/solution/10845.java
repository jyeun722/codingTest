import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int orders = Integer.parseInt(st.nextToken());
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < orders; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    que.add(x);
                    break;
                case "pop":
                    if (que.isEmpty()) System.out.println(-1);
                    else System.out.println(que.remove());
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (que.isEmpty()) System.out.println(-1);
                    else System.out.println(que.peek());
                    break;
                case "back":
                    if (que.isEmpty()) System.out.println(-1);
                    else System.out.println(que.peekLast());
                    break;
                default:
                    break;
            }
        }
    }
}
