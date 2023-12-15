import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        String init = br.readLine();
        LinkedList<String> inits = new LinkedList<>(Arrays.asList(init.split("")));
	// ArrayList: 정렬, LinkedList: 추가 및 제거

        int idx = init.length();
        ListIterator<String> result = inits.listIterator(idx);
	// ListInterator로 List 편집 가능 (영향이 감)

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);

            switch (order) {
                case 'L':
                    if (result.hasPrevious()) result.previous();
                    break;
                case 'D':
                    if (result.hasNext()) result.next();
                    break;
                case 'B':
                    if (result.previousIndex() != -1) {
                        result.previous();
                        result.remove();
                    }
                    break;
                case 'P':
                    String plus = st.nextToken();
                    result.add(plus);
                    break;
                default:
                    break;
            }
        }

        String print = inits.toString().replaceAll("[^a-z]", "");
        bw.append(print);
        bw.flush();
        bw.close();
    }
}
