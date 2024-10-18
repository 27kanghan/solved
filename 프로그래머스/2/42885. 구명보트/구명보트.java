import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int startIdx = 0;
        int endIdx = people.length-1;
        
        while(true){
            
            if(startIdx > endIdx) break;
            
            if(people[startIdx] + people[endIdx] <= limit){
                startIdx++;
            }
            
            endIdx--;
            
            answer++;
            
            
            
            
        }
        
        
        return answer;
    }
}