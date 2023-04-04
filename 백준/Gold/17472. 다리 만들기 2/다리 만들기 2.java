import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int map[][];
	static int N, M;
	static int num;
	static boolean visited[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int arr[][];

	static StringBuilder sb = new StringBuilder();

	/**
	 * 1. 섬 번호 매기기 2. 완탐으로 섬 to 섬 다리 연결하기 3. 다리 연결된 정보를 토대로 노드 번호 정리하기 4. 정리된 노드
	 * 기반으로 MST 적용해서 완성
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫 섬을 발견하면 1로 바꿔주고 bfs 다 돌면 섬 한개 처리했다는 뜻
		// 첫 섬 처리 다끝내면 다음 섬 찾았을 때 번호를 늘려줘야 하기 때문에 num++;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);

				}
			}
		}
		// bfs 끝

		arr = new int[num + 1][num + 1];

		for (int i = 0; i < num + 1; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}

		// 다리 연결하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j, map[i][j]);
				}
			}
		}



		mst();

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void mst() {
		boolean[] visit = new boolean[num + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		pq.add(new int[] { 1, 0 });
		int a = 0;

		int ans = 0;
		while (!pq.isEmpty()) {
			int a1[] = pq.poll();

			int w = a1[0];
			int cost = a1[1];

			if (visit[w])
				continue;

			visit[w] = true;
			a++;
			ans += cost;
			if (a == num)
				break;
			for (int i = 0; i < arr[w].length; i++) {
				if (arr[w][i] != Integer.MAX_VALUE && !visit[i])
					pq.add(new int[] { i, arr[w][i] });

			}
		}

		if (a == num) {
			sb.append(ans);
		} else {
			sb.append(-1);
		}

	}


	private static void makeBridge(int i, int j, int from) {
		int dr1[] = { 1, 0 };
		int dc1[] = { 0, 1 };
		int ii = i;
		int jj = j;
		int move = 0;

		while (true) {
			int nr = i + dr1[0];
			int nc = j + dc1[0];

			if (!check(nr, nc) || map[nr][nc] == from)
				break;

			if (map[nr][nc] == 0) {
				move++;
				i = nr;
				j = nc;
				continue;
			}


			if (move < 2)
				break;

			if (arr[from][map[nr][nc]] > move)
				arr[from][map[nr][nc]] = arr[map[nr][nc]][from] = move;
			break;
		}

		move = 0;
		i = ii;
		j = jj;

		while (true) {
			int nr = i + dr1[1];
			int nc = j + dc1[1];

			if (!check(nr, nc) || map[nr][nc] == from)
				break;

			if (map[nr][nc] == 0) {
				move++;
				i = nr;
				j = nc;
				continue;
			}

			if (move < 2)
				break;

			if (arr[from][map[nr][nc]] > move)
				arr[from][map[nr][nc]] = arr[map[nr][nc]][from] = move;
			break;

		}

	}

	/**
	 * 
	 * @param x,y 섬 발견했을 때 좌표 발견 한 섬을 각 번호로 매겨주기.
	 * 
	 */
	private static void bfs(int x, int y) {
		num++;
		Queue<Point> q = new ArrayDeque<>();

		q.add(new Point(x, y));
		
		map[x][y] = num;

		Point cur = null;
		while (!q.isEmpty()) {
			cur = q.poll();

			int r = cur.r;
			int c = cur.c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					map[nr][nc] = num;
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}