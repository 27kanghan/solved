import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		// tc
		int N = Integer.parseInt(st.nextToken());
		// 레이팅 합
		int K = Integer.parseInt(st.nextToken());
		// 개인레이팅
		int L = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int arr[] = new int[3];
			boolean flag = true;

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[j] = n;
				sum += n;
				if (n < L)
					flag = false;
			}

			if (flag) {
				if (sum >= K) {
					cnt++;
					sb.append(arr[0] + " ");
					sb.append(arr[1] + " ");
					sb.append(arr[2] + " ");

				}

			}
		}

		bw.write(Integer.toString(cnt) + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}