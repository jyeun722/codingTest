import java.util.*;
import java.io.*;

public class Main {
    private static final int SPLIT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String binary = st.nextToken();
        int remain = binary.length() % 3;
        if (remain != 0) {
            binary = "0".repeat(SPLIT - remain) + binary;
        }

        ArrayList<String> bins = new ArrayList<>(Arrays.asList("000", "001", "010", "011", "100", "101", "110", "111"));
        HashMap<String, Integer> binsMap = new HashMap<>();
        for (int i = 0; i < bins.size(); i++) {
            binsMap.put(bins.get(i), i);
        }

        for (int i = 0; i < binary.length(); i += SPLIT) {
            String check = binary.substring(i, i + SPLIT);

            int idx = binsMap.get(check);
            bw.append(idx + ""); // 메모리 초과 방지
        }

        bw.flush();
        bw.close();
    }
}
