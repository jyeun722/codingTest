import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int open = 0, close = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') open++;
                else close++;

                if (open < close) {
                    break;
                }
            }
            if (open != close) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.print(sb);
    }
}
