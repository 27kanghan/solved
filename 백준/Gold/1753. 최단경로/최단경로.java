import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 간선 정보 저장
	 * 
	 * @author SSAFY
	 *
	 */
	static class Vertex implements Comparable<Vertex> {
		int no;
		int weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		final int INF = Integer.MAX_VALUE;
		// 정점
		int V = Integer.parseInt(st.nextToken());
		// 간선
		int E = Integer.parseInt(st.nextToken());
		// 시작점
		int start = Integer.parseInt(br.readLine());
		// 인접 리스트
		ArrayList<Vertex>[] list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Vertex(no, weight));
		}

		// 초기화

		// 갈 수 없는 곳 초기화

		boolean visited[] = new boolean[V+1];

		int distance[] = new int[V+1];
		Arrays.fill(distance, INF);

		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		distance[start] = 0;
		pq.offer(new Vertex(start, distance[start]));

		Vertex cur = null;

		while (!pq.isEmpty()) {
			cur = pq.poll();

			if (visited[cur.no])
				continue;

			visited[cur.no] = true;

			for (Vertex vertex : list[cur.no]) {
				if (distance[vertex.no] > distance[cur.no] + vertex.weight) {
					distance[vertex.no] = distance[cur.no] + vertex.weight;
					pq.offer(new Vertex(vertex.no, distance[vertex.no]));
				}
			}
//			for (int i = 0; i < V; i++) {
//				if (adjMatrix[cur.no][i] != 0 && distance[i] > adjMatrix[cur.no][i] + cur.weight) {
//					distance[i] = adjMatrix[cur.no][i] + cur.weight;
//					pq.offer(new Vertex(i, distance[i]));
//				}
//
//			}
//		}
//

		}
		for (int i = 1; i <= V; i++) {
			System.out.println(distance[i] != INF ? distance[i] : "INF");
		}

	}
}