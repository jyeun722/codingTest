import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (i1, i2) -> {
            return i1[1] != i2[1] ? i1[1] - i2[1] : i1[0] - i2[0];
        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1] + '\n');
        }
        System.out.println(sb);
    }
}
