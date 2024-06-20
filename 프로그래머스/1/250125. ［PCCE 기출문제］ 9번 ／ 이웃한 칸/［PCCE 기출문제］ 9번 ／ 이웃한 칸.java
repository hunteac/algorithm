class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int len = board.length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dr[i];
            int nw = w + dc[i];
            if (nh < 0 || nh >= len || nw < 0 || nw >= len) continue;
            if (board[h][w].equals(board[nh][nw])) answer++;
        }
        
        return answer;
    }
}