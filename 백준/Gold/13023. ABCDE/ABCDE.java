import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> list;
	static int V, E;
	static boolean visited[];
	static int res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(from).add(to);
			list.get(to).add(from);
		}

		

		for (int i = 0; i < V; i++) {
			visited = new boolean[V];
			int cnt = 0;
			if(dfs(i, cnt)) {
				res = 1;
				break;
			}
		}
		System.out.println(res);
		
	}

	private static boolean dfs(int cur, int cnt) {
		visited[cur] = true;
		
		if(cnt == 4) {
			return true;
		}
		
		
		
		for (int num : list.get(cur)) {
			if (!visited[num]) {
				if(dfs(num, cnt+1))
				return true;
			}
		}
		visited[cur] = false;
		
		return false;

	}

}