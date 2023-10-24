import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M]; // 공간
		boolean[][] visited = new boolean[N][M]; // 방문 체크
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 8방향 탐색
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Pos> queue = new LinkedList<>();
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				queue.add(new Pos(i, j));
				visited = new boolean[N][M];
				int cnt = -1;
				while (!queue.isEmpty()) {
					int len = queue.size();
					cnt++;
					
					for (int k = 0; k < len; k++) {
						Pos p = queue.poll();
						
						int r = p.r;
						int c = p.c;
						
						if (map[r][c] == 1) {
							max = Math.max(max, cnt);
							queue.clear();
							break;
						}
						
						for (int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
							
							visited[nr][nc] = true;
							
							queue.add(new Pos(nr, nc));
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
}