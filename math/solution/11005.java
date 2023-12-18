import java.util.*;
import java.io.*;

public class Main {
    private static final int ALPHA = 10;
    private static final int TO_CHAR = 55;

    public static void divide(ArrayList<String> list, long num, int b) {
        if (num < b) {
            int check = Integer.parseInt(list.get(0));
            if (check >= ALPHA) {
                list.set(0, (char) (check + TO_CHAR) + "");
            }
            return;
        }
        list.remove(0);

        if (b < ALPHA) {
            list.add(0, Long.toString(num % b));
        } else {
            String remain = num % b >= ALPHA ? (char) (num % b + TO_CHAR) + "" : Long.toString(num % b);
            list.add(0, remain);
        }
        list.add(0, Long.toString(num / b));

        divide(list, num / b, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<String> result = new ArrayList<>(Arrays.asList(Long.toString(n)));
        if (b == ALPHA) {
            bw.append(Long.toString(n));
        } else {
            divide(result, n, b);
            bw.append(String.join("", result));
        }

        bw.flush();
        bw.close();
    }
}

