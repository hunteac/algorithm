import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited; // 방문 체크
	static int[][] map; // 입력 행렬
	static int[][] edges; // 출력 행렬
	static int N; // 정점 개수
	
	static void dfs (int start, int r) {
		
		for (int c = 0; c < N; c++) {
			if (map[r][c] == 0 || visited[r][c]) continue;
			
			visited[r][c] = true; // 방문 처리
			edges[start][c] = 1; // 양수인 경로 존재
			
			dfs(start, c); // 재귀 함수 호출
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		edges = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) continue;
				
				visited = new boolean[N][N];
				
				dfs(i, i); // 깊이 우선 탐색
			}
		}
		
		for (int[] arr : edges) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}