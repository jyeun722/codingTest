import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
	    int result = N;
		for (int i = 0; i < N; i++) {
		    char[] arr = br.readLine().toCharArray();
		    
		    HashSet<Character> set = new HashSet<>();
		    char cur = '-';
		    for (int j = 0; j < arr.length; j++) {
		        if (cur == arr[j]) continue;
		        cur = arr[j];
		        
		        int size = set.size();  
		        set.add(arr[j]);
		        if (set.size() == size) {
		            result--;
		            break;
		        }
		    }
		}
		
		bw.append(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
