import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static int E;
	static int ans = Integer.MAX_VALUE;
	static int pop[];
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());

		pop = new int[V + 1];

		// 인구수 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= V; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		// 리스트 초기화
		adjList = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}

		// 연결 정보 저장
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjList.get(i).add(to);
			}

		}
//		System.out.println(adjList.toString());

		visited = new boolean[V + 1];


		subSet(1);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}

	}

	private static void subSet(int cnt) {
		if(cnt == V+1) {
			if(check()) {
				int sumA = 0, sumB = 0;
				for (int i = 1; i <= V; i++) {
					if (visited[i]) sumA += pop[i];
					else sumB += pop[i];	
					
				}
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			return;
		}
		
		visited[cnt] = true;
		subSet(cnt+1);
		visited[cnt] = false;
		subSet(cnt+1);
		
		
	}

	private static boolean check() {
		boolean isSelected[] = new boolean[V+1];
		
		int areaA = -1;
		
		for (int i = 1; i <= V; i++) {
			if(visited[i]) {
				areaA = i;
				break;
			}
		}
		
		int areaB = -1;
		for (int i = 1; i <= V; i++) {
			if(!visited[i]) {
				areaB = i;
				break;
			}
		}
		
		if(areaA == -1 || areaB == -1)return false;
		
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(areaA);
		isSelected[areaA] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < adjList.get(cur).size(); i++) {
				// 이미 확인한 곳 체크
				if(isSelected[adjList.get(cur).get(i)]) continue;
				
				// A구역인지 체크
				if(!visited[adjList.get(cur).get(i)]) continue;
				isSelected[adjList.get(cur).get(i)] = true;
				q.add(adjList.get(cur).get(i));
			}
		}
		
		
		q.add(areaB);
		isSelected[areaB] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < adjList.get(cur).size(); i++) {
				// 이미 확인한 곳 체크
				if(isSelected[adjList.get(cur).get(i)]) continue;
				
				// B구역인지 체크
				if(visited[adjList.get(cur).get(i)]) continue;
				isSelected[adjList.get(cur).get(i)] = true;
				q.add(adjList.get(cur).get(i));
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(!isSelected[i])
				return false;
		}

		
		return true;
	}

}