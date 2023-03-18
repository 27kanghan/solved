import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int input[] = new int [9];
	static int arr[] = new int[7];
	static boolean visited[] = new boolean[9];
	static boolean flags;

	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
	
		perm(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void perm(int cnt) {
		
		if(flags) return;
		
		if(cnt == 7) {
			int sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			
			if(sum == 100) {
				Arrays.sort(arr);
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i] + "\n");
				}
				flags = true;
	
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			arr[cnt] = input[i];
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
		
	}
	
	
	
}