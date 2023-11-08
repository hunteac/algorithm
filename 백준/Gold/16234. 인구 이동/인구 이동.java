import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	
	static List<Integer[]> list; // 국경선이 열린 나라들을 담는 리스트
	static Queue<Pos> queue; 
	static boolean[][] visited; // 방문 체크
	static int[][] map; // 나라 지도
	static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
	static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
	static int N; // 땅 크기
	static int L;
	static int R;
	static int cnt; // 인구 이동이 발생한 날짜
	static int sum; // 국경선이 열린 나라들의 인구수 합
	static boolean chk; // 인구 이동 가능 여부
	
	static void bfs(int a, int b) {
		queue.add(new Pos(a, b));
		list.add(new Integer[] {a, b});
		visited[a][b] = true;
		
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			
			int r = p.r;
			int c = p.c;
		
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] ||
						Math.abs(map[r][c] - map[nr][nc]) < L || Math.abs(map[r][c] - map[nr][nc]) > R)
					continue;
				
				visited[nr][nc] = true; // 방문 처리
				sum += map[nr][nc]; // 인구수 더하기
				chk = true; // 인구 이동 가능
				
				queue.add(new Pos(nr, nc));
				list.add(new Integer[] {nr, nc}); // 나라 좌표 담기
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue = new LinkedList<>();
		chk = true;
		
		while (chk) {
			visited = new boolean[N][N]; // 초기화
			chk = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue; // 이미 국경선이 열려있으면 continue
					list = new ArrayList<>();
					sum = map[i][j];
					bfs(i, j);
					
					if (chk) { // 인구 이동이 가능하면 인구수 변화
						int size = list.size();
						while (!list.isEmpty()) {
							Integer[] arr = list.remove(0);
							map[arr[0]][arr[1]] = sum / size;
						}
					}
				}
			}
			
			if (!chk) break; // 인구 이동 불가능
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}