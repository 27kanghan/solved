import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//x 좌표 저장
		List<Integer> xList = new ArrayList<>();
		//y 좌표 저장
		List<Integer> yList = new ArrayList<>();
		//가로
		int N = Integer.parseInt(st.nextToken());
		//세로
		int M = Integer.parseInt(st.nextToken());
		// Tc
		int T = Integer.parseInt(br.readLine());
		// 0,0 부터 시작.
		xList.add(0);
		yList.add(0);
		
		// 값 삽입
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				xList.add(b);
			}
			else {
				yList.add(b);
			}
		}
		
		
		// N, M까지기 떄문에 삽입.
		xList.add(N);
		yList.add(M);
		
		//먼저 잘린거 판별용 정렬
		Collections.sort(xList);
		Collections.sort(yList);
		

		
		//정답 저장
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 1; i < xList.size(); i++) {
			int xIndex = xList.get(i) - xList.get(i-1);
		
			for (int j = 1; j < yList.size(); j++) {
				int yIndex = yList.get(j) - yList.get(j-1);
			
				ans.add(xIndex * yIndex);
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.get(ans.size()-1));
		
	}

}