import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		
		int visited[] = new int[100001];
		

		int start = N;

		if (N >= K) {
			System.out.println(N-K);
		} else {
			System.out.println(bfs(start, K, visited));
		}
	}
	

	private static int bfs(int start, int K, int[] visited) {
		Queue<Integer> q = new ArrayDeque<>();

		
		q.offer(start);
		visited[start] = 1;
		
		while (!q.isEmpty()) {

			int cur = q.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0 ) {
					next = cur+1;
				
				}
				else if (i == 1) {
					next = cur-1;
				
					
				}
				else if (i == 2) {
					next = cur*2;
				
				}
				if(next == K) {
					return visited[cur];
				}
				if(next >=0 && next <= 100000) {
					if(visited[next] == 0) {
						q.offer(next);
						visited[next] = visited[cur] + 1;
					}
				}
			}
			

		}
		return 0;

	}
	

}