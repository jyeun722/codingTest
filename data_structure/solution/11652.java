import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        long value = 0;
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            int cnt = map.get(num);
            if ((max < cnt) || (max == cnt && num < value)) {
                max = map.get(num);
                value = num;
            }
        }
        System.out.println(value);
    }
}

