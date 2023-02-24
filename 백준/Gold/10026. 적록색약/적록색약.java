import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char greed1[][];
	static char greed2[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N, cnt, cnt2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		greed1 = new char[N][N];
		greed2 = new char[N][N];

		for (int i = 0; i < N; i++) {
			String color = br.readLine();
			for (int j = 0; j < N; j++) {
				greed1[i][j] = color.charAt(j);
				if (color.charAt(j) == 'R' || color.charAt(j) == 'G') {
					greed2[i][j] = 'R';
				}
				
			}
		}
		
		
		
	
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (greed1[i][j] != 'x') {
					dfs1(i, j);
					cnt++;			
				}
				if (greed2[i][j] != 'x') {
					dfs2(i, j);
					cnt2++;			
				}
				
			}
		}

		System.out.println(cnt+ " " + cnt2);

	}

	private static void dfs1(int x, int y) {

		char cur = greed1[x][y];
		greed1[x][y] = 'x';
		int nx;
		int ny;

		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (isPossible(cur, nx, ny)) {
				dfs1(nx, ny);
			}

		}
		
	}

	private static boolean isPossible(char cur, int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N && greed1[nx][ny] == cur && greed1[nx][ny] != 'x';
	}
	
	private static void dfs2(int x, int y) {

		char cur = greed2[x][y];
		greed2[x][y] = 'x';
		int nx;
		int ny;

		for (int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if (isPossible2(cur, nx, ny)) {
				dfs2(nx, ny);
			}

		}
		
	}

	private static boolean isPossible2(char cur, int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N && greed2[nx][ny] == cur && greed2[nx][ny] != 'x';
	}

}