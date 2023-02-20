import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		
		cut(row, col, size);
		
		System.out.println(cnt);
	}
	private static void cut(int r, int c, int size) {
		
		
		if(size == 1) {
			return;
		}
		
		
		//1사분면
		if(r < size/2 && c < size/2 ) {
			cut(r, c, size/2);
		}//2사분면
		else if(r < size/2 && c >= size/2) {
			cnt += (size * size) / 4;
			cut(r, c-size/2, size/2);
		}//3사분면
		else if(r >= size/2 && c < size/2) {
			cnt += (size * size) / 4 * 2;
			cut(r-size/2, c, size/2);
		}//4사분면
		else {
			cnt += (size * size) / 4 * 3;
			cut(r-size/2, c-size/2, size/2);
		}
		
		
		
		
		
		
		
		
	}

}