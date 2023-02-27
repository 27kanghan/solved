import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		int num = N - N % 100;
		while (true) {

			if (num % F == 0) {
				break;
			}
			
			num++;

		}
		
		num = num %100;
		System.out.printf("%02d", num);

	}

}