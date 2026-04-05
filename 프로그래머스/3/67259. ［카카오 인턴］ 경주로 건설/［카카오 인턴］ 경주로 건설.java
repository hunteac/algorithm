import java.util.*;

class Solution {
    public class Road implements Comparable<Road> {
        int r;
        int c;
        int cost;
        int dir;
        
        Road(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
        
        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        
        PriorityQueue<Road> pq = new PriorityQueue<>();
        int[][][] dp = new int[N][N][4];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        pq.add(new Road(0, 0, 0, -1));
        
        while(!pq.isEmpty()) {
            Road road = pq.poll();
            int r = road.r;
            int c = road.c;
            int cost = road.cost;
            int dir = road.dir;
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (board[nr][nc] == 0) {
                        int totalCost = cost;
                        
                        if (dir == -1 || dir % 2 == d % 2) { // 직선
                            totalCost += 100;
                        } else { // 코너
                            totalCost += 600;
                        }
                        
                        if (dp[nr][nc][d] >= totalCost) {
                            dp[nr][nc][d] = totalCost;
                            pq.add(new Road(nr, nc, totalCost, d));
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[N - 1][N - 1][i]);
        }
        
        return answer;
    }
}