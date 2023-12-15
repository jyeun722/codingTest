import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        ArrayList<String> dic = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            dic.add(str.substring(i, str.length()));
        }

        Collections.sort(dic);
        for (int i = 0; i < dic.size(); i++) {
            System.out.println(dic.get(i));
        }
    }
}
