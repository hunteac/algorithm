import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> edges;
	static boolean[] visited;
	static int[] nodeSet;
	static int V, E;
	static boolean chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			visited = new boolean[V + 1];
			nodeSet = new int[V + 1];
			chk = true;
			
			for (int i = 0; i <= V; i++) {
				edges.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				edges.get(u).add(v);
				edges.get(v).add(u);
			}
			
			for (int i = 1; i <= V; i++) {
				if (!chk) break;
				
				if (!visited[i]) {
					nodeSet[i] = 1;
					dfs(i, 1);
				}
			}
			
			if (chk) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}

		System.out.println(sb);
	}
	
	public static void dfs(int curr, int num) {
		visited[curr] = true;
		
		for (int i = 0; i < edges.get(curr).size(); i++) {
			int next = edges.get(curr).get(i);
			
			if (!visited[next]) {
				nodeSet[next] = -num;
				dfs(next, -num);
			} else if (nodeSet[curr] == nodeSet[next]) {
				chk = false;
			}
		}
	}
}