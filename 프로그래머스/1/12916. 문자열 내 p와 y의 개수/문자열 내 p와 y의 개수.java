class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0;
        int yCnt = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p') pCnt++;
            else if(s.charAt(i) == 'y') yCnt++;
        }
        
        if(pCnt == yCnt) answer = true;
        else answer= false;
        

        return answer;
    }
}