class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        boolean flag = true;
        int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 행 탐색
        int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 열 탐색
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) continue; // 지뢰가 놓인 지역은 continue
                flag = true;
                for (int d = 0; d < 8; d++) {
                    if (i + dr[d] >= 0 && i + dr[d] < len && j + dc[d] >= 0 && j + dc[d] < len && board[i + dr[d]][j + dc[d]] == 1)
                        flag = false; // 범위 내의 지뢰 존재 여부 파악
                }
                if (flag) answer++; // 지뢰가 없다면 + 1
            }
        }
        return answer;
    }
}