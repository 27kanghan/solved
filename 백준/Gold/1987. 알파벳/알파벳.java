import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean visited[];
	static int R, C;
	static int res = 0;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}

		}

		dfs(0, 0, 0);

		System.out.println(res);
	}

	private static void dfs(int count, int x, int y) {

		if (visited[map[x][y]]) {
			res = Math.max(res, count);
			return;
		}
		visited[map[x][y]] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (isPossible(nx, ny)) {
				dfs(count + 1, nx, ny);
			}

		}
		visited[map[x][y]] = false;

	}

	private static boolean isPossible(int nx, int ny) {
		return nx >= 0 && nx < R && ny >= 0 && ny < C;
	}

}
