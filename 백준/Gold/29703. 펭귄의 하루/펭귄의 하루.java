import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int r; // 현재 행
		int c; // 현재 열
		boolean chk; // 물고기 섭취 여부

		Pos(int r, int c, boolean chk) {
			this.r = r;
			this.c = c;
			this.chk = chk;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][][] visited = new boolean[2][N][M];
		char[][] map = new char[N][M];

		Queue<Pos> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') { // 출발 위치 저장
					queue.add(new Pos(i, j, false));
					visited[0][i][j] = true;
				}
			}
		}

		int[] dr = { -1, 0, 1, 0 }; // 행 탐색
		int[] dc = { 0, 1, 0, -1 }; // 열 탐색
		boolean check = false; // 가능 여부
		int time = 0; // 최소 시간

		Outer: while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				Pos curr = queue.poll();

				int r = curr.r;
				int c = curr.c;
				boolean chk = curr.chk;

				if (map[r][c] == 'H' && chk) { // 집 도착
					check = true;
					break Outer;
				}

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'D')
						continue;
					if ((!chk && visited[0][nr][nc]) || (chk && visited[1][nr][nc]))
						continue;

					if (!chk) // 물고기 X
						visited[0][nr][nc] = true;
					else // 물고기 O
						visited[1][nr][nc] = true;

					if (map[nr][nc] == 'F') // 물고기 서식지
						queue.add(new Pos(nr, nc, true));
					else // 다른 지역
						queue.add(new Pos(nr, nc, chk));
				}
			}

			time++; // 시간 증가
		}

		if (check)
			System.out.println(time);
		else
			System.out.println(-1);

	}
}
