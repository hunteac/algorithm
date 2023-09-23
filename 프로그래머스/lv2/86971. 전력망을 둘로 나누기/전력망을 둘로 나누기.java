import java.util.*;

class Solution {
    static boolean[][] visited; // 방문
    static boolean[][] edges; // 인접 행렬
    static int min; // 송전탑 개수 차 최솟값
    static int cnt; // 연결된 송전탑 수
    
    // 깊이 우선 탐색
    static void DFS(int row) {
        for (int i = 1; i < edges.length; i++) {
            if (visited[row][i]) continue;
            visited[row][i] = visited[i][row] = true; // 방문 체크
            if (edges[row][i]) {
                DFS(i);    
                cnt++;
            } 
        }
    }
    
    public int solution(int n, int[][] wires) {
        edges = new boolean[n + 1][n + 1];
        min = Integer.MAX_VALUE; 
        
        for (int i = 0; i < wires.length; i++) {
            edges[wires[i][0]][wires[i][1]] = true;
            edges[wires[i][1]][wires[i][0]] = true; 
        }
        
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1][n + 1];
            edges[wires[i][0]][wires[i][1]] = false; // 연결 끊기
            edges[wires[i][1]][wires[i][0]] = false;
            
            cnt = 1;
            
            DFS(wires[i][0]);
                
            min = Math.min(min, Math.abs((n - cnt) - cnt));
            
            edges[wires[i][0]][wires[i][1]] = true; // 재연결
            edges[wires[i][1]][wires[i][0]] = true;
        }
        
        return min;
    }
}