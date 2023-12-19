import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int result = 1;

        for (int i = input; i > 1; i--) {
            result *= i;
        }

        bw.append(result + "");
        bw.flush();
        bw.close();
    }
}
