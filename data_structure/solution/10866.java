import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int orderCnt = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < orderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push_front":
                    int numFront = Integer.parseInt(st.nextToken());
                    que.addFirst(numFront);
                    break;
                case "push_back":
                    int numBack = Integer.parseInt(st.nextToken());
                    que.addLast(numBack);
                    break;
                case "pop_front":
                    if (que.isEmpty()) bw.append(-1 + "\n");
                    else bw.append(que.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if (que.isEmpty()) bw.append(-1 + "\n");
                    else bw.append(que.removeLast() + "\n");
                    break;
                case "size":
                    bw.append(que.size() + "\n");
                    break;
                case "empty":
                    if (que.isEmpty()) bw.append(1 + "\n");
                    else bw.append(0 + "\n");
                    break;
                case "front":
                    if (que.isEmpty()) bw.append(-1 + "\n");
                    else bw.append(que.peekFirst() + "\n");
                    break;
                case "back":
                    if (que.isEmpty()) bw.append(-1 + "\n");
                    else bw.append(que.peekLast() + "\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
