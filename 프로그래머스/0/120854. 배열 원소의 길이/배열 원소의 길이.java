class Solution {
    public int[] solution(String[] strlist) {
        
        int len = strlist.length;
        
        int[] answer = new int[len];
        
        for(int i = 0; i < strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        
        
        return answer;
    }
}