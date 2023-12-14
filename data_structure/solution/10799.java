import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String parenthesis = st.nextToken();
        parenthesis = parenthesis.replaceAll("\\(\\)", "-");

        Stack<Integer> pars = new Stack<>();

        int nums = 0, result = 0;
        for (String par : parenthesis.split("")) {
            if (par.equals("(")) {
                nums++;
                pars.push(0);
            } else if (par.equals(")")) {
                pars.pop();
            } else {
                result += pars.size();
            }
        }

        System.out.println(result + nums);
    }
}
