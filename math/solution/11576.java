import java.util.*;
import java.io.*;

public class Main {
    public static void divide(ArrayList<String> list, long num, int b) {
        if (num < b) {
            return;
        }
        list.remove(0);

        list.add(0, Long.toString(num % b));
        list.add(0, Long.toString(num / b));

        divide(list, num / b, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        long ten = 0;
        for (int i = 0, j = nums.size() - 1; i < nums.size(); i++, j--) {
            ten += Math.pow(a, j) * nums.get(i);
        }

        ArrayList<String> result = new ArrayList<>(Arrays.asList(Long.toString(ten)));
        if (b == a) {
            String answer = nums.toString();
            bw.append(answer.replaceAll("[^0-9 ]", ""));
        } else {
            divide(result, ten, b);
            bw.append(String.join(" ", result));
        }

        bw.flush();
        bw.close();
    }
}
