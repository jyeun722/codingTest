import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String kor = sc.next();
            String eng = sc.next();
            String math = sc.next();
            arr[i][0] = kor;
            arr[i][1] = eng;
            arr[i][2] = math;
            arr[i][3] = name;
        }

        Arrays.sort(arr, (i1, i2) -> {
            if (i1[0].equals(i2[0])) {
                if (i1[1].equals(i2[1])) {
                    if (i1[2].equals(i2[2])) {
                        return i1[3].compareTo(i2[3]);
                    }
                    return Integer.parseInt(i2[2]) - Integer.parseInt(i1[2]);
                }
                return Integer.parseInt(i1[1]) - Integer.parseInt(i2[1]);
            }
            return Integer.parseInt(i2[0]) - Integer.parseInt(i1[0]);
        });


        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][3]);
        }
    }
}
