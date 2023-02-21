import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char map[][];
	static int R, C, cnt;
	static int dx[] = { 0, 1, -1 };
	static int dy[] = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			if(bt(i, 0))
				cnt++;	
		}
		
		System.out.println(cnt);

		

	}

	private static boolean bt(int r, int c) {
		map[r][c] = 'x';
		
		if(c == C-1) {
			return true;
		}
		//오른쪽 위
		if(r > 0 && map[r-1][c+1] == '.') {
			if(bt(r-1, c+1))
			return true;
			
		}
		if(map[r][c+1] == '.'){//오른쪽
			if(bt(r, c+1))
			return true;
		}
		if(r+1 < R && map[r+1][c+1] == '.'){//오른쪽 아래
			if(bt(r+1, c+1))
			return true;
		}
		
		return false;
			
	}
	
}