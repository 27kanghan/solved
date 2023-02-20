import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int arr[][], blue, white;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
		
		
	}

	private static void cut(int r, int c, int size) {
		
		int sum = 0;
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for (int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size * size) {
			blue++;
		}
		else if(sum == 0){
			white++;
		}
		else{
			int half = size/2;
			cut(r, c, half);
			cut(r+half, c, half);
			cut(r, c+half, half);
			cut(r+half, c+half, half);
			
		}
		
	}

}