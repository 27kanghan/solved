import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static int N;
	// 가로 대각 세로
	static int dr[] = { 0, 1, 1 };
	static int dc[] = { 1, 1, 0 };
	// 정답
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 배열의 크기
		N = Integer.parseInt(br.readLine());
		// 초기화
		map = new int[N][N];
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs 호출
		dfs(0, 1, 0);

		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	/**
	 * 
	 * @param r : 시작 r좌표
	 * @param c : 시작 c 좌표 시작 r,c 좌표는 첫 파이프의 끝부분이 위치한 0,1
	 * @param d : 파이프의 방향 정보. 0 가로 1 대각 2 세로
	 */
	private static void dfs(int r, int c, int d) {

		// 기저조건, 끝에 도달하면 ans 1회씩 추가.
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}

		// nr, ny control
		int nr = 0;
		int nc = 0;

		// 가로로 놓여있을 때
		if (d == 0) {
			// 가로와 대각 가능
			for (int dir = 0; dir < 2; dir++) {
				nr = r + dr[dir];
				nc = c + dc[dir];

				// 유효성 검사
				if (!check(nr, nc) || map[nr][nc] != 0)
					continue;
				// 대각으로 갈 때
				if (dir == 1) {
					if (map[nr - 1][nc] == 1 || map[nr][nc] == 1 || map[nr][nc - 1] == 1)
						continue;
				}

				dfs(nr, nc, dir);
			}

		}
		if (d == 1) { // 대각일 때
			// 가로 세로 대각 가능
			for (int dir = 0; dir < 3; dir++) {
				nr = r + dr[dir];
				nc = c + dc[dir];

				// 유효성 검사
				if (!check(nr, nc) || map[nr][nc] != 0)
					continue;
				// 대각으로 갈 때
				if (dir == 1) {
					if (map[nr - 1][nc] == 1 || map[nr][nc] == 1 || map[nr][nc - 1] == 1)
						continue;
				}

				dfs(nr, nc, dir);
			}

		}
		if (d == 2) { // 세로일 때
			// 세로와 대각 가능
			for (int dir = 1; dir < 3; dir++) {
				nr = r + dr[dir];
				nc = c + dc[dir];

				// 유효성 검사
				if (!check(nr, nc) || map[nr][nc] != 0)
					continue;
				// 대각으로 갈 때
				if (dir == 1) {
					if (map[nr - 1][nc] == 1 || map[nr][nc] == 1 || map[nr][nc - 1] == 1)
						continue;
				}

				dfs(nr, nc, dir);
			}

		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}