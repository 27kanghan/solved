class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int binaryCnt = 0;
        
        binaryCnt = makeBinary(n);
        
        for(int i = n+1; i <= 1000000; i++){
            
            if(binaryCnt == makeBinary(i)){
                answer = i;
                break;
            }
            
            
        }
        
        return answer;
    }
    
    public static int makeBinary(int num){
        
        int binaryCnt = 0;
        
        while(true){
            
            if(num % 2 == 1){
                binaryCnt++;
            }
            
            num = num / 2;
            
            if(num == 1){
                binaryCnt++;
                break;
            }
            
        }
        
        return binaryCnt;
        
                
    }
}