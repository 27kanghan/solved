class Solution {
    public int[] solution(long n) {
        
        String len = String.valueOf(n);
        
        int[] answer = new int[len.length()];
        
        int cnt = 0;
        
        for(int i = len.length()-1; i >= 0; i--){
            answer[i] = len.charAt(cnt)-'0';
            cnt++;
            
        }
        
        return answer;
    }
}