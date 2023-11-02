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
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Pos> queue;
	static boolean[][] visited; // 방문 체크
	static char[][] map; // 입력 행렬
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N; // 행 크기
	static int M; // 열 크기
	static int answer = 0; 
	
	static void BFS(int a, int b) {
		queue.add(new Pos(a, b));
		visited[a][b] = true;
		
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			
			int r = p.r;
			int c = p.c;
			
			if (map[r][c] == 'P') answer++;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 'X' || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				
				queue.add(new Pos(nr, nc));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		queue = new LinkedList<>();
		visited = new boolean[N][M];
		map = new char[N][M];
		
		int r = 0; // 출발 행 좌표
		int c = 0; // 출발 열 좌표
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					r = i;
					c = j;
				}
			}
		}
		
		BFS(r, c); // 너비 우선 탐색
		
		if (answer != 0) System.out.println(answer); // 만나는 경우
		else System.out.println("TT"); // 못 만나는 경우
	}
}