import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int time;

		public Fish(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		//
		@Override
		public int compareTo(Fish o) {
			if (this.time == o.time) {
				if (this.x == o.x) {
					if (this.y > o.y) {
						return 1;
					} else {
						return -1;
					}
				} else {
					if (this.x > o.x) {
						return 1;
					} else {
						return -1;
					}
				}
			} else if (this.time > o.time) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	static int N;
	static int[][] map;
	static boolean visited[][];

	static Fish shark;
	static int size = 2;
	static int eat = 0;

	static PriorityQueue<Fish> feedList = new PriorityQueue<>();
	static int answer;
	// 상 하 좌 우
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}

		bfs();
		sb.append(answer);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void bfs() {
		Queue<Fish> q = new ArrayDeque<>();
		q.add(shark);
		visited[shark.x][shark.y] = true;

		while (true) {
			while (!q.isEmpty()) {
				Fish cur = q.poll();
				int time = cur.time;

				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (!(nx >= 0 && nx < N && ny >= 0 && ny < N) || visited[nx][ny])
						continue;

					// 식사가 가능하면
					if (map[nx][ny] < size && map[nx][ny] != 0) {
						q.add(new Fish(nx, ny, time + 1));
						visited[nx][ny] = true;
						feedList.add(new Fish(nx, ny, time + 1));
					}

					// 이동만 가능
					if (map[nx][ny] == size || map[nx][ny] == 0) {
						q.add(new Fish(nx, ny, time + 1));
						visited[nx][ny] = true;
					}

				}
			}

			if (!feedList.isEmpty()) {
				eat();

				q.clear();
				visited = new boolean[N][N];

				q.add(shark);
				visited[shark.x][shark.y] = true;
			} else {
				return;
			}
		}

	}

	private static void eat() {
		Fish cur = feedList.poll();
		
		shark.x = cur.x;
		shark.y = cur.y;
		
		if(++eat == size) {
			size++;
			eat = 0;
		}
		
		answer += cur.time;
		
		map[cur.x][cur.y] = 0;
		
		feedList.clear();
		
		
		
	}

}
