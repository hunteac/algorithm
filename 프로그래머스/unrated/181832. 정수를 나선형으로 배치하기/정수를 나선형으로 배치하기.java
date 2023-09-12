class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 순으로 진행
        int[] dc = { 1, 0, -1, 0 };
        int r = 0; // 행 탐색
        int c = 0; // 열 탐색
        int d = 0; // 방향 전환 변수
        int cnt = 1;
        answer[0][0] = cnt++;
        while (cnt <= n * n) {
            int tmpr = r + dr[d];
            int tmpc = c + dc[d];
            
            if (tmpr < 0 || tmpr >= n || tmpc < 0 || tmpc >= n || answer[tmpr][tmpc] != 0) { // 배열 범위를 벗어나거나 이미 채워진 공간을 만나면 방향 바꾸기
                d = (d + 1) % 4;
                tmpr = r + dr[d];
                tmpc = c + dc[d];
            }
            r = tmpr;
            c = tmpc;
            answer[r][c] = cnt++;
        }
        return answer;
    }
}