import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 1, ee = 1, ss = 1, mm = 1; i < Integer.MAX_VALUE; i++, ee++, ss++, mm++) {
            if (ee > 15) ee = 1;
            if (ss > 28) ss = 1;
            if (mm > 19) mm = 1;
            if (ee == e && ss == s && mm == m) {
                System.out.println(i);
                return;
            }
        }
    }
}
