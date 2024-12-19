import java.util.*;

class Solution {
    public String solution(String s) {
        
        //97 ~ 122
        //65 ~ 90
        String answer = "";
        
        String str[] = s.toLowerCase().split("");
        
        if(str[0].charAt(0) >= 97 && str[0].charAt(0) <= 122){
            str[0] = str[0].toUpperCase();
        }
        
        answer += str[0];
         
        for(int i = 1; i < str.length; i++){
            if(str[i-1].equals(" ")){
                System.out.println("!23");
                str[i] = str[i].toUpperCase();
            }
            
            answer += str[i];
        }

        
        

        
        return answer;

    }
}
