import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		private int r;
		private int c;
		private int len;
		private boolean[][] visited;
		
		Pos(int r, int c, int len, boolean[][] visited) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.visited = visited;
		}
		
		public int getR() {
			return this.r;
		}
		
		public int getC() {
			return this.c;
		}
		
		public int getLen() {
			return this.len;
		}
		
		public boolean[][] getVisited() {
			return this.visited;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(R - 1, 0, 1, new boolean[R][C]));
		
		int targetR = 0;
		int targetC = C - 1;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			int currR = p.getR();
			int currC = p.getC();
			int len = p.getLen();
			boolean[][] visited = p.getVisited();
			
			visited[currR][currC] = true;
			
			for (int d = 0; d < 4; d++) {
				int nextR = currR + dr[d];
				int nextC = currC + dc[d];
				if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C 
						|| len >= K || visited[nextR][nextC] || map[nextR][nextC] == 'T') continue;
				
				boolean[][] newVisited = new boolean[R][C];
				for (int i = 0; i < R; i++) newVisited[i] = visited[i].clone();
				
				if (nextR == targetR && nextC == targetC) {
					if (len + 1 == K) cnt++;
				} else {
					queue.add(new Pos(nextR, nextC, len + 1, newVisited));
				}
			}
		}
		
		System.out.println(cnt);
	}
}