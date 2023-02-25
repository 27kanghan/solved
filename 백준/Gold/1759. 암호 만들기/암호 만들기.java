import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	//암호의 개수
	static int L;
	//단어의 개수
	static int C;
	//단어 저장 배열
	static char[] words;
	//암호 저장 배열
	static char[] password;
	//선택 여부
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		words = new char[C]; 
		password = new char[L]; 
		isSelected = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			words[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(words);
		
	
		combi(0, 0);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}


	private static void combi(int cnt,int start) {

		if(cnt == L) {
			String str = "";
			if(check(password)) {	
				for (int i = 0; i < L; i++) {
					str += password[i];
				}
				list.add(str);
			}	
			
			return;
		}
		
		
		for (int i = start; i < C; i++) {
			if(isSelected[i]) continue;
			password[cnt] = words[i];
			isSelected[i] = true;
			combi(cnt+1, i+1);
			isSelected[i] = false;
		}
		
		
		
		
	}


	private static boolean check(char[] password) {
		int count = 0;
		for (int i = 0; i < password.length; i++) {
			if(password[i] == 'a' || password[i] == 'e'
					||password[i] == 'i'||password[i] == 'o'|| password[i] == 'u') {
				count++;
			}
		}
		if(count > 0 && count < L-1) {
			return true;
		}
		
		return false;

		
	}

}