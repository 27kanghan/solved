import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Point {
		int r;
		int c;
		int cnt;
		int dir;
		public Point(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

	}

	// 각 각 배열 크기, 시간, 군집 개수
	static int N, M, K;
	// 각각 미생물 개수, 큰 값 저장, 방향 저장
	static int[][] microCnt, microBig, microDir;

	static List<Point> micro = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			// N, M, K
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			// 테케 돌 때마다 리스트 초기화
			micro.clear();

			microCnt = new int[N][N];
			microBig = new int[N][N];
			microDir = new int[N][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				// 미생물 정보 저장
				micro.add(new Point(r, c, cnt, dir));
			}

			// M초 동안의 움직임

			for (int i = 0; i < M; i++) {
				clear();
				move();
				arange();
			}

			int sum = 0;

			for (Point p : micro) {
				sum += p.cnt;
			}

			sb.append(sum).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void arange() {
		// 움직일 때 정보 저장
		// 한개 씩 꺼내서 정보를 배열에 저장하고,
		// cnt가 0이되면 리스트에서 제거해주고,
		// 아니라면 밑에서 다시 추가.


		int size = micro.size();

		for (int i = size - 1; i >= 0; i--) {
			
			if(micro.get(i).cnt == 0) {
				micro.remove(i);
				continue;
			}
			
			int r = micro.get(i).r;
			int c = micro.get(i).c;
			int cnt = micro.get(i).cnt;
			int dir = micro.get(i).dir;

			if (microCnt[r][c] == 0) {
				microCnt[r][c] = cnt;
				microBig[r][c] = cnt;
				microDir[r][c] = dir;
			} else {
				microCnt[r][c] += cnt;
				if (microBig[r][c] < cnt) {
					microBig[r][c] = cnt;
					microDir[r][c] = dir;
				}
			}
		}

		micro.clear();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				micro.add(new Point(i, j, microCnt[i][j], microDir[i][j]));
			}
		}

	}

	private static void move() {
		// 움직일 때. 1상 2하 3좌 4우 절반이면?

		for (Point point : micro) {
			// 상
			if (point.dir == 1) {
				if (--point.r == 0) {
					point.cnt /= 2;
					point.dir = 2;

				}
			}
			else if (point.dir == 2) { // 하
				if (++point.r == N - 1) {
					point.cnt /= 2;
					point.dir = 1;
				}
			}
			else if (point.dir == 3) { // 좌
				if (--point.c == 0) {
					point.cnt /= 2;
					point.dir = 4;
				}
			}
			else if (point.dir == 4) {
				// 우
				if (++point.c == N - 1) {
					point.cnt /= 2;
					point.dir = 3;
				}
			}

		}

	}

	private static void clear() {

		for (int i = 0; i < N; i++) {
			Arrays.fill(microBig[i], 0);
			Arrays.fill(microCnt[i], 0);
			Arrays.fill(microDir[i], 0);
		}

	}

}
