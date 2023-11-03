import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 구역 크기
	static boolean[][] visited; // 방문 체크
	static char[][] map; // 구역
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	static void dfs(int r, int c, int num, char color) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
			
			if (num == 0 && map[nr][nc] != color) continue; // 적록색약이 아닌 경우
			else if (num == 1) { // 적록색약인 경우
				if (color == 'B' && map[nr][nc] != color) continue;
				else if ((color == 'R' || color == 'G') && map[nr][nc] == 'B') continue;
			}
			
			visited[nr][nc] = true; // 방문 처리
			
			dfs(nr, nc, num, color);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int t = 0; t < 2; t++) {
			visited = new boolean[N][N];
			int cnt = 0; // 구역 개수
			for (int i = 0; i < N; i++) { // 구역 탐색
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					dfs(i, j, t, map[i][j]); // 깊이 우선 탐색
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}
}