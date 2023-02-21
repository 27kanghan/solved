import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, arr[]; // 판의 크기 , 퀸 위치 담을 배열. index = 퀸의 r값, 배열 안에는 퀸의 c값을 삽입.
	public static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		
		nQueen(0);
		System.out.println(cnt);
		
		
		
	}
	private static void nQueen(int depth) {
		
		if(depth == N) {
			cnt++;
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			
			
			if(isPossiblity(depth)){
				nQueen(depth+1);
			}
		}
		
	}
	private static boolean isPossiblity(int col) {
		for (int i = 0; i < col; i++) {
			
			if(arr[col] == arr[i]) {
				return false;
			}
			else if( Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
			

		}
		return true;
	}
}