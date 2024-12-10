class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int serviceCnt = n / 10;
        
        answer = n * 12000 + (k-serviceCnt) * 2000;
        
        
        return answer;
    }
}