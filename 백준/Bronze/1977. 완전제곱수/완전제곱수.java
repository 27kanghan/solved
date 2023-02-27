import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int i = 1;

		while (true) {
			int pow = i * i;
			if (pow > N) {
				break;
			}

			if (pow >= M && pow <= N) {
				sum += pow;
				min = Math.min(pow, min);
			}

			i++;

		}
		if (min == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(sum);
			sb.append("\n");
			sb.append(min);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}