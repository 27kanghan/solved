import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			adjList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			// 입력 개수
			int V = Integer.parseInt(st.nextToken());

			// 시작 정점
			int start = Integer.parseInt(st.nextToken());

			// 리스트 초기화, 인원은 최대 100명, 1번부터.
			for (int i = 0; i <= 100; i++) {
				adjList.add(new ArrayList<>());
			}

			// 초기화 한 리스트에 값 대입
			// from - to이기 때문에 값의 절반
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList.get(from).add(to);
			}

			sb.append("#").append(tc).append(" ").append(bfs(start)).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int bfs(int start) {
		boolean visited[] = new boolean[101];
		Queue<Integer> q = new ArrayDeque<>();

		q.add(start);
		visited[start] = true;
		int last = 0;
		int size = 0;

		while (!q.isEmpty()) {
			last = 0;
			size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				last = Math.max(cur, last);
				for (int num : adjList.get(cur)) {
					if (visited[num]) {
						continue;
					}
					visited[num] = true;
					q.add(num);

				}
			}
		}
		return last;

	}

}
