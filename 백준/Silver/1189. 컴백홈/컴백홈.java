import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, K, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(R - 1, 0, 1);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r, int c, int len) {
		if (r == 0 && c == C - 1 && len == K) cnt++;
		
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nextR = r + dr[d];
			int nextC = c + dc[d];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
					|| (len + 1 > K) || visited[nextR][nextC] || map[nextR][nextC] == 'T')
				continue;
			
			dfs(nextR, nextC, len + 1);
		}
		
		visited[r][c] = false;
	}
}