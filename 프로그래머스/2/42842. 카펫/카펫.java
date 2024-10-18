import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalArea = brown + yellow;
        boolean flags = false;
        
        for(int i = 1; i <= totalArea; i++){
            if(flags) break;
            for(int j = 1; j <= totalArea; j++){
                if (i < j) break;
                if(i * j == totalArea){
                    if((i-2) * (j-2) == yellow){
                        flags = true;
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                    
                }
            }
        }
        
        
        
        return answer;
    }
}