class Solution {
    int[][] board;
    int[][] t;
    int n, m;
    int min = Integer.MAX_VALUE;
    
    public void flip_row (int r) {
        // 0 -> 1, 1 -> 0
        for (int i = 0; i < m; i++) board[r][i] = (board[r][i]+1)%2;
    }
    
    public int compare_col (int c) {
        int check = 0;
        for (int i = 0; i < n; i++) {
            if (t[i][c] == board[i][c]) {
                check++; 
            } 
        }
        
        if (check == n) return 0; // 전부 일치
        else if ( check == 0) return 1; // 전부 불일치
        else return -1;
    }
    
    public void dfs(int r, int cnt){
        // 모든 행의 경우의 수를 확인했다면
        if (r == n) {
            boolean flag = true;
            for(int i = 0; i < m; i++) {
                int result = compare_col(i);
                if (result == -1) {
                    flag = false;
                    break;
                }
                cnt += result; //전부 반대일 경우 +1
            }
            
            if (flag) {
                min = Math.min(min, cnt);   
            }
            return;
        }
        
        flip_row(r); // 행 뒤집기
        dfs(r + 1, cnt + 1); // 행을 뒤집는 경우
        flip_row(r); // 다시 원상태로
        
        dfs(r + 1, cnt); // 행을 뒤집지 않는 경우
    }
    
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        
        board = new int[n][m];
        
        for(int i=0; i<n; i++) board[i] = beginning[i];
        
        t = target;
        
        dfs(0, 0);
        
        if (min != Integer.MAX_VALUE) return min;
        else return -1;
    }
}