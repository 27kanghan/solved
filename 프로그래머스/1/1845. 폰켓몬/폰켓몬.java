import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> st = new HashSet<Integer>();
        
        int limit = nums.length/2;
        
        for(int i = 0; i < nums.length; i++){
            st.add(nums[i]);
        }
        

        if(limit < st.size()){
            return limit;
        }

        return st.size();
    }
}