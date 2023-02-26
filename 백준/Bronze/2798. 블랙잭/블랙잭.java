import java.util.Scanner;

public class Main {
	static int N, R, ans;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		subset(0, 0);

		System.out.println(ans);
	}

	private static void subset(int cnt, int start) {

		if (cnt == 3) {
			int sum = 0;
			int smin = 0;

			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (sum > R) {
				return;
			}
			smin = Math.abs(sum - R);

			if (min > smin) {
				min = smin;
				ans = sum;
			}

			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			subset(cnt + 1, i + 1);
			visited[i] = false;
		}

	}

}