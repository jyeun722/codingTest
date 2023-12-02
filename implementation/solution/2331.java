import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int p = Integer.parseInt(st.nextToken());

        ArrayList<String> arr = new ArrayList<>();
        while (!arr.contains(a)) {
            arr.add(a);
            int sum = 0;
            for (String value : a.split("")) {
                sum += Math.pow(Integer.parseInt(value), p);
            }
            a = Integer.toString(sum);
        }
        int idx = arr.indexOf(a);
        System.out.println(idx);
    }
}
