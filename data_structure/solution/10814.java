import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[n][2];
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            map.put(i, name);
            arr[i][0] = age;
            arr[i][1] = i;
        }

        Arrays.sort(arr, (i1, i2) -> {
            return i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1];
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + map.get(arr[i][1]));
        }
    }
}
