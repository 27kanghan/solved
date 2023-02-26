import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int arr[][] = new int[100][100];
		int size = 10;
		int sum = 0;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (arr[i][j] == 1) {
						arr[i][j] = 0;
					}

					arr[i][j] = 1;

				}
			}

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

}
