import java.util.*;
class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        
        int len = str.length();
        
        int arr[] = new int[len];
        
        long answer = 0;
        
        for(int i = 0 ; i < len; i++){
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr);
        
        str = "";
        
        for(int i = len-1; i >= 0; i--){
            str += arr[i];
        }
        
        answer = Long.parseLong(str);
        
        return answer;
    }
}