import java.util.*;

class Solution {
    static class Pos {
        int r;
        int c;
        int dist;
        
        Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    static Queue<Pos> queue; // BFS 큐
    static boolean[][] visited; // 방문 체크
    static int[][] map; // 지도 복사본
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int min; // 최솟값
    static boolean chk; // 도착 가능 여부
    
    // 너비 우선 탐색(BFS)
    static void BFS(int r, int c, int n) {
        queue.add(new Pos(r, c, n));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int cr = p.r; // 현재 행 좌표
            int cc = p.c; // 현재 열 좌표
            int dist = p.dist; // 현재 거리
            
            if (cr == map.length - 1 && cc == map[0].length - 1) { // 상대평 진영에 도달하면
                min = dist; // 현재 거리
                chk = true;
                break; // 반복문 탈출
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d]; // 다음 행 좌표
                int nc = cc + dc[d]; // 다음 열 좌표
                // 방문했거나 탐색할 수 없는 칸은 continue
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc] || map[nr][nc] == 0)
                    continue;
                visited[nr][nc] = true; // 방문 처리
                queue.add(new Pos(nr, nc, dist + 1));
            }
        }
    }
    
    public int solution(int[][] maps) {
        queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];
        map = maps;
        
        BFS(0, 0, 1); // 탐색 시작    
        
        if (chk) return min; // 도달할 수 있다면 최솟값 출력
        else return -1; // 도달할 수 없다면 -1 출력
    }
}