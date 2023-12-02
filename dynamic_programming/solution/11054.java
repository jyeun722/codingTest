import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] dpLR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dpLR[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
                }
            }
        }
        
        int[] dpRL = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            dpRL[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpRL[i] = Math.max(dpRL[i], dpRL[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dpLR[i] + dpRL[i]);
        }
        System.out.println(max - 1);
    }
}

