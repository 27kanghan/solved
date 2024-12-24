import java.util.*;

class Solution {
    public int[] solution(int[] numList) {
        
        int len = numList.length;
        
        int[] answer = new int[len];
        
        int cnt = 0;
        for(int i = len-1; i >= 0; i--){
            answer[i] = numList[cnt++];
            
        }
        
        return answer;
    }
}