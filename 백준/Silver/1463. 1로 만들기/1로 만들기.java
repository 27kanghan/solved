import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n + 1];
		if (n == 1) {
			System.out.println(0);
			return;
		}
		if (n == 2 || n == 3) {
			System.out.println(1);
			return;
		}

		Arrays.fill(arr, Integer.MAX_VALUE);

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for (int i = 4; i < arr.length; i++) {

			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			}

			arr[i] = Math.min(arr[i], arr[i - 1] + 1);

		}

		System.out.println(arr[n]);
	}

}
