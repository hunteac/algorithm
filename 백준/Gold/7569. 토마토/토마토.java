import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int h;
		int r;
		int c;
		
		Pos (int h, int r, int c){
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Pos> queue;
	static int N; // 세로
	static int M; // 가로
	static int H; // 높이
	static boolean[][][] visited; // 방문 체크
	static int[][][] map; // 토마토 밭
	static int[] dr = { 0, 0, -1, 0, 1, 0 }; // 행 탐색
	static int[] dc = { 0, 0, 0, 1, 0, -1 }; // 열 탐색
	static int[] dh = { 1, -1, 0, 0, 0, 0 }; // 높이 탐색
	static int min; // 최소 시간
	
	static void bfs() {
		while (!queue.isEmpty()) {
			int len = queue.size();
			
			for (int i = 0; i < len; i++) {
				Pos p = queue.poll();
				
				int h = p.h;
				int r = p.r;
				int c = p.c;

				for (int d = 0; d < 6; d++) {
					int nh = h + dh[d];
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= M || nc >= N || 
							visited[nh][nr][nc] || map[nh][nr][nc] == -1)
						continue;
					
					visited[nh][nr][nc] = true;
					map[nh][nr][nc] = 1;
					
					queue.add(new Pos(nh, nr, nc));
				}
			}
			
			min++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken()); 
		
		queue = new LinkedList<>();
		visited = new boolean[H][M][N];
		map = new int[H][M][N];
		
		boolean chk = true;
		
		for (int h = 0; h < H; h++) {
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					map[h][m][n] = Integer.parseInt(st.nextToken());
					if (map[h][m][n] == 1) {
						queue.add(new Pos(h, m, n));
						visited[h][m][n] = true;
					}
					else if (map[h][m][n] == 0) chk = false;
				}
			}
		}
		
		if (chk) {
			System.out.println(0);
			return;
		}
		
		min = -1;
		
		bfs();
		
		for (int h = 0; h < H; h++) {
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					if (map[h][m][n] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(min);
	}
}