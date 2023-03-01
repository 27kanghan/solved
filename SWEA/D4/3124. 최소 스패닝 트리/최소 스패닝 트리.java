import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		
	}

	public static void makeSet() {
		parents = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	}
	public static int findSet(int x) {
		if(parents[x] == x) return x;
		
		return findSet(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		if(xRoot == yRoot) return false;
		
		if(xRoot > yRoot)parents[xRoot] = yRoot;
		else parents[yRoot] = xRoot;
		return true;
	}
	static int V, E;
	static int parents[];
	static Edge edgeList[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
		
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			
			makeSet();
			
			Arrays.sort(edgeList);
			
			long result = 0;
			int count = 0;
			int min = Integer.MAX_VALUE;
			for (Edge e : edgeList) {
				if(union(e.from, e.to)) {	
					result += e.weight;
					if(++count == V-1) {
						break;
					}
				}
			}
			sb.append(result);
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		
		
	}

}