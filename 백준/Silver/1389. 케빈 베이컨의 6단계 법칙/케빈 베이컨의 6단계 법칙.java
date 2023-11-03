import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[][] visited;
	static boolean[][] edges;
	static int[][] rel;
	
	static void dfs(int start, int r, int dist) {
		if (rel[start][r] != 0) rel[start][r] = Math.min(rel[start][r], dist); 
		else rel[start][r] = dist;
		for (int c = 1; c <= N; c++) {
			if ((start != r && edges[start][c]) || visited[r][c] || !edges[r][c]) continue;
			visited[r][c] = visited[c][r] = true;
			dfs(start, c, dist + 1);
			visited[r][c] = visited[c][r] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new boolean[N + 1][N + 1];
		rel = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			edges[A][B] = true;
			edges[B][A] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1][N + 1];
			dfs(i, i, 0);
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				sum += rel[i][j];
			}
			
			if (min > sum) {
				min = sum;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
}