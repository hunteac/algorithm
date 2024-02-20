class Solution {
    static boolean[][] visited; // 방문 체크
    static int[][] map; // 지형
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int min; // 최소 거리
    
    static void searchItem(int r, int c, int itemY, int itemX, int dist) {
        visited[r][c] = true; // 방문 처리
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr == itemY && nc == itemX) { // 아이템 발견
                min = Math.min(min, dist + 1); // 최소값 갱신
                return;
            }
            // 범위를 벗어나거나 이미 방문한 곳은 continue
            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] != 1 || visited[nr][nc]) continue;
            searchItem(nr, nc, itemY, itemX, dist + 1); // 이동
        }
    }    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 지형 가로, 세로 2배 늘리기
        visited = new boolean[101][101];
        map = new int[101][101];
        
        for (int idx = 0; idx < rectangle.length; idx++) {
            for (int r = rectangle[idx][1] * 2; r <= rectangle[idx][3] * 2; r++) {
                for (int c = rectangle[idx][0] * 2; c <= rectangle[idx][2] * 2; c++) {
                    // 모서리 == 1, 내부 == 2
                    if ((r == rectangle[idx][1] * 2 || r == rectangle[idx][3] * 2 || c == rectangle[idx][0] * 2 || c == rectangle[idx][2] * 2) && map[r][c] == 0) {
                    map[r][c] = 1;
                    } else if (r != rectangle[idx][1] * 2 && r != rectangle[idx][3] * 2 && c != rectangle[idx][0] * 2 && c != rectangle[idx][2] * 2) {
                        map[r][c] = 2;
                    }
                }
            }
        }
        
        min = Integer.MAX_VALUE;
        
        searchItem(characterY * 2, characterX * 2, itemY * 2, itemX * 2, 0);
        
        return min / 2;
    }
}