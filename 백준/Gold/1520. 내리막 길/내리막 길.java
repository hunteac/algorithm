import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[][] map; // 지도
	static int[][] dp; // 동적계획법
	static boolean[][] visited; // 방문 체크
	static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
    static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
	
	static int DFS(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return dp[r][c] = 1;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; // 다음 행
			int nc = c + dc[d]; // 다음 열
			if (nr < 0 || nc < 0 || nr >= M || nc >= N || map[r][c] <= map[nr][nc]) continue;
                
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				dp[r][c] += DFS(nr, nc);
			} else {
				dp[r][c] += dp[nr][nc];
			}
		}
		return dp[r][c];
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        DFS(0, 0); // 0, 0 시작
        
        System.out.println(dp[0][0]);
    }
}