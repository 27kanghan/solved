import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;

	static void makeset(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

	}

	static int findset(int x) {

		if ((x == parents[x])) {
			return x;
		}
		return parents[x] = findset(parents[x]);

	}

	static int union(int a, int b) {
		int xRoot = findset(a);
		int yRoot = findset(b);

		if (xRoot == yRoot) {
			return 0;
		}
		
		if (xRoot > yRoot) {
			parents[yRoot] = xRoot;
		}
		else {
			parents[xRoot] = yRoot;
		}
		return 1;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		// TC
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			st = new StringTokenizer(br.readLine());
			// 자연수 범위 (배열의 크기)
			int n = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];

			makeset(n);

			int m = Integer.parseInt(st.nextToken());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (num == 1) {
					if (findset(a) == findset(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else {

					union(a, b);

				}
			}
			sb.append("\n");
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}