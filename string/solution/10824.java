import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long first = Long.parseLong(st.nextToken() + st.nextToken());
        long second = Long.parseLong(st.nextToken() + st.nextToken());

        System.out.println(first + second);
    }
}
