class Solution {
    public boolean solution(int x) {
        
        int num = x;
        
        int sum = 0;
        
        while(true){
               
            sum += num % 10;
            
            num /= 10;


if(num == 0) break;
        
            
        }

        
        // return true;
        if(x % sum == 0) return true;
        else return false;
    }
}