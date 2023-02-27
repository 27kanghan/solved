import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int n1 = N;
		int res = 0;

		while (n1 > 1) {
			int sum = 0;
			n1--;
			String n2 = Integer.toString(n1);
			for (int i = 0; i < n2.length(); i++) {
				sum += (Integer.parseInt(n2.substring(i, i + 1)));
			}
			sum += n1;


			
			if (sum == N)
				res = n1;
			
			
	

		}
		System.out.println(res);
	}

}