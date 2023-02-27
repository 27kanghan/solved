import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int num = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				num = i;
				cnt++;
			}

			if (cnt == K)
				break;

		}
		if(cnt < K) {
			sb.append(0);
		}
		else {
			sb.append(num);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

	}

}