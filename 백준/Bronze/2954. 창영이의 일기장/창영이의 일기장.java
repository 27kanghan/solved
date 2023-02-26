import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static Queue<String> input = new ArrayDeque<>();
	static Queue<String> output = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			input.add(str.substring(i, i + 1));

		}

		check(str);

	}

	private static void check(String str) {

		String nStr;
		while(!input.isEmpty()) {
			nStr = input.poll();
			if (nStr.equals("a") || nStr.equals("i")|| nStr.equals("e") || nStr.equals("o") || nStr.equals("u")) {
				output.offer(nStr);
				input.poll();
				input.poll();
			} else {
				output.offer(nStr);
				
			}

		}
		while (!output.isEmpty()) {
			System.out.print(output.poll());
		}

	}

}