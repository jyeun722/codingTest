import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        for (int i = 2; input != 1; ) {
            if (input % i == 0) {
                bw.append(i + "\n");
                input /= i;
            } else {
                i++;
            }
        }

        bw.flush();
        bw.close();
    }
}
