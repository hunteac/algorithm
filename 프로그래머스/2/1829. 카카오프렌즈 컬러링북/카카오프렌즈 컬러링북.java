class Solution {
    static boolean[][] visited; // 방문 체크
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int numberOfArea; // 영역 수
    static int maxSizeOfOneArea; // 영역 최대 크기
    static int sizeOfOneArea; // 영역 크기
    
    static void checkSize(int[][] picture, int r, int c, int color) {
        sizeOfOneArea++;
        visited[r][c] = true; // 방문 처리
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea); // 최대 크기 갱신
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 범위를 벗어나거나 이미 방문한 곳이거나 다른 색상이면 continue
            if (nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length || visited[nr][nc] || picture[nr][nc] != color) continue;
            checkSize(picture, nr, nc, color); // 다음 영역 이동
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        
        visited = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // 색이 없거나 방문한 영역은 continue
                if (picture[r][c] == 0 || visited[r][c]) continue;
                numberOfArea++; // 영역 수 증가
                sizeOfOneArea = 0; // 영역 크기 초기화
                checkSize(picture, r, c, picture[r][c]); // 영역 탐색 시작
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}