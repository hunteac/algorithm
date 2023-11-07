import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited; // 방문 체크
	static int[][] cheeze; // 치즈
	static int[] dr = { -1, 0, 1, 0 }; // 행 탐색
	static int[] dc = { 0, 1, 0, -1 }; // 열 탐색
	static int N; // 행 크기
	static int M; // 열 크기
	
	
	static void dfs(int r, int c) {
		visited[r][c] = true; // 방문 처리
		cheeze[r][c] = 0; // 내부 공기 -> 외부 공기 전환
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; // 다음 행 좌표
			int nc = c + dc[d]; // 다음 열 좌표
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || 
					cheeze[nr][nc] == 1 || cheeze[nr][nc] == 0)
				continue;
			
			dfs(nr, nc); // 칸 이동
		}
	}
	
	// 외부 공기 체크
	static void check (int r, int c) {
		visited[r][c] = true; // 외부 공기 방문 체크
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; // 다음 행 좌표
			int nc = c + dc[d]; // 다음 열 좌표
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || 
					cheeze[nr][nc] == 1)
				continue;
			
			check(nr, nc); // 칸 이동
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());				
		
		visited = new boolean[N][M];
		cheeze = new int[N][M]; 

		int cnt = 0; // 치즈 조각 수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
				if (cheeze[i][j] == 1) { // 치즈 조각 수 구하기
					cnt++;
				}
			}
		}
		
		check(0, 0); // 외부 공기 체크
		
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (cheeze[i][j] == 1 || visited[i][j]) continue;
				
				cheeze[i][j] = 2; // 내부 공기
			}
		}
		
		visited = new boolean[N][M]; // 방문 체크 초기화
		
		List<Integer[]> list = new ArrayList<>(); // 녹는 치즈 좌표
		int time = 0; // 치즈가 모두 녹는 시간
		
		// 치즈가 모두 녹을 때까지 반복문 실행
		while (cnt > 0) {
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (cheeze[i][j] == 0 || cheeze[i][j] == 2) continue;
					
					int num = 0; // 외부 공기와 맞닿는 면의 수 
					
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if (cheeze[nr][nc] == 0) num++;
					}
					
					// 두 개 이상이 맞닿으면 치즈 녹이기
					if (num >= 2) list.add(new Integer[] {i, j});
				}
			}
			
			// 치즈 녹이기
			while (!list.isEmpty()) {
				cheeze[list.get(0)[0]][list.get(0)[1]] = 0;
				
				for (int d = 0; d < 4; d++) {
					int nr = list.get(0)[0] + dr[d];
					int nc = list.get(0)[1] + dc[d];
					if (cheeze[nr][nc] == 2 && !visited[nr][nc]) dfs(nr, nc);
				}
				
				list.remove(0);
				cnt--;
			}
			
			time++;
		}
		
		System.out.println(time);
	}
}