import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 자연수
		int k = sc.nextInt(); // k 번째로 작은 것
		int cnt = 0;
		int index = 0;
		
		for(int i = 1; i <= n; i++) {
			index = n % i;
			if(index == 0) {
				cnt++;
			}	
			if(cnt == k) {
				System.out.println(i);
				break;
				
			}
			
			
				
			}
		if(cnt < k) {
			System.out.println(0);
	
		}
				
	

}
}

