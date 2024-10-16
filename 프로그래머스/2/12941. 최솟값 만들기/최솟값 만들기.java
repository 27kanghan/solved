import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            // System.out.println(A[i] + " " + B[A.length-1]);
            sum += A[i] * B[A.length-i-1]; 
        }


        return sum;
    }
}