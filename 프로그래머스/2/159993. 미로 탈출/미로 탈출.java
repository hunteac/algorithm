import java.util.*;

class Solution {
    static class Pos { // 위치
        int r; // 현재 행
        int c; // 현재 열
        int dist; // 레버를 당기고 난 후 출구까지 거리
        int ldist; // 레버까지 거리
        
        Pos (int r, int c, int dist, int ldist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.ldist = ldist;
        }
    }
    
    static Queue<Pos> queue; // BFS 큐
    static boolean[][] visited; // 방문 처리
    static String[][] maze; // 미로
    static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
    static int min; // 최소 거리
    static int ldist; // 레버 거리
    static boolean chk; // 레버 당기기
    
    // 너비 우선 탐색
    static void BFS(int a, int b) {
        queue.add(new Pos(a, b, 0, 0));
        visited[a][b] = true;
        
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c; 
            int dist = p.dist;
            int ldist = p.ldist;
            
            if (chk && maze[r][c].equals("E")) { // 탈출
                min = dist + ldist;
                break;
            }
            
            if (maze[r][c].equals("L")) { // 레버 당기기
                chk = true;
                queue.clear(); // 큐 비우기
                visited = new boolean[maze.length][maze[0].length]; // 방문 배열 초기화
                visited[r][c] = true; // 방문 처리
            } 
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d]; // 다음 행
                int nc = c + dc[d]; // 다음 열
                // 범위를 벗어나거나 벽이 있으면 continue
                if (nr < 0 || nc < 0 || nr >= maze.length || nc >= maze[0].length || visited[nr][nc] 
                    || maze[nr][nc].equals("X")) continue;
                
                visited[nr][nc] = true; // 방문 처리
                
                if (chk) queue.add(new Pos(nr, nc, dist + 1, ldist)); // 레버 당긴 후
                else queue.add(new Pos(nr, nc, dist, ldist + 1)); // 레버 당기기 전
            }   
        }
    }
    
    public int solution(String[] maps) {
        min = Integer.MAX_VALUE;
    
        queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length()];
        maze = new String[maps.length][maps[0].length()];
        
        chk = false;
        
        int r = 0; // 출발 행
        int c = 0; // 출발 열
        
        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for (int j = 0; j < maps[0].length(); j++) {
                maze[i][j] = String.valueOf(s.charAt(j));
                if (maze[i][j].equals("S")) { // 시작 위치
                    r = i;
                    c = j;
                }
            }
        }

        BFS(r, c);
    
        if (min == Integer.MAX_VALUE) return -1; // 탈출 불가능
        else return min; // 탈출 가능
    }
}