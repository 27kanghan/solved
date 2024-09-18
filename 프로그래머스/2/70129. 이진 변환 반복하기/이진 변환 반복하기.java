import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int changeCount = 0;
        int zeroCount = 0;
        
        int cnt = 0;
        while(true){
            
            String newStr = "";

            
            if(s.equals("1")) break;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1') {
                    newStr += s.charAt(i);
                }else {
                   zeroCount++; 
                }
                
            }
            
            
            int length = newStr.length();
            
            
            s = Integer.toBinaryString(length);
                        
        
            changeCount++;
            cnt++;
              
        }
        
        answer[0] = changeCount;
        answer[1] = zeroCount;
        
        
        return answer;
    }
}