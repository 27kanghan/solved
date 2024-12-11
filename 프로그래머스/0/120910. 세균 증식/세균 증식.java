import java.math.*;

class Solution {
    public int solution(int n, int t) {
        
        //n - 세균 마리수
        //t - 경과 시간
        
        int answer = n;
        
        for(int i = 0; i < t; i++){
            answer *= 2;
        }

        
        return answer;
    }
}