class Solution {
    
    int answer = 0;
    boolean visited[];
    
    public int solution(int n, int[][] computers) {
        // int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            
            dfs(n, i, computers);
            answer++;
            
        }
        
        return answer;
    }
    
    
    public void dfs(int n, int start, int computers[][]){
        
        visited[start] = true;
        
        for(int i = 0; i < n; i++){
            if(i == start) continue;
            
            if(!visited[i] && computers[start][i] == 1){
                dfs(n, i, computers);
            }
            
        }
        
        
    }
}