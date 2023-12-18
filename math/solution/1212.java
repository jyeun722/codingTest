import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        String oct = st.nextToken();
        if (oct.equals("0")) {
            System.out.println("0");
            return;
        }

	// or Map 사용
        ArrayList<String> bins = new ArrayList<>(Arrays.asList("000", "001", "010", "011", "100", "101", "110", "111"));

        int[] octs = Arrays.stream(oct.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < oct.length(); i++) {
            String bin = bins.get(octs[i]);
            sb.append(bin);
        }

        String result = sb.toString();
        while (result.startsWith("0")) {
            result = result.substring(1, result.length());
        }
        bw.append(result);
        bw.flush();
        bw.close();
    }
}
