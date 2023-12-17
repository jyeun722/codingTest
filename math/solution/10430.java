import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.append(((A + B) % C) + "\n");
        bw.append((((A % C) + (B % C)) % C) + "\n");
        bw.append(((A * B) % C) + "\n");
        bw.append((((A % C) * (B % C)) % C) + "\n");

        bw.flush();
        bw.close();
    }
}
