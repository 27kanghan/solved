import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		cut(0, 0, N);
		System.out.println(sb.toString());
		
	}
	private static void cut(int r, int c, int size) {
		int sum = 0;
	
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for (int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += arr[i][j];
			}
		}
	
		if(sum == size * size) {
			sb.append(1);
			
		}
		else if(sum == 0) {
			sb.append(0);
			
		}
		else {
			int half = size/2;
			sb.append("(");
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			sb.append(")");
			
		}
		
		
		
	}
	

}