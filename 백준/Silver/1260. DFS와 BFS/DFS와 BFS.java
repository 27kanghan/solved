import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int V;
	static boolean visited[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 간선 개수
		V = Integer.parseInt(st.nextToken());
		// 노드 개수
		int E = Integer.parseInt(st.nextToken());
		// 시작 노드 번호
		int start = Integer.parseInt(st.nextToken());

		// 리스트 배열 초기화

		visited = new boolean[V+1];
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
	

		// 리스트에 담기

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(from).add(to);
			list.get(to).add(from);

		}
		for (int i = 1; i < V+1; i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(start);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(start);

	}

	private static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		for (int num : list.get(start)) {
			if(!visited[num]) {
				dfs(num);
			}
		}
		

	}

	private static void bfs(int start) {
		
		Queue<Integer> q = new ArrayDeque<>();
		// 첫 노드 담기
		q.offer(start);
		// 첫 노드 방문처리
		visited[start] = true;
		int cur = 0;
		while (!q.isEmpty()) {
			cur = q.poll();
			System.out.print(cur + " ");
			for (int num : list.get(cur)) {
				if(!visited[num]) {
					visited[num] = true;
					q.offer(num);
				}
			}
		}

	}

}