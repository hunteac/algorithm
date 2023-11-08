import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] edges = new LinkedList[N + 1]; // 연결 리스트
		
		for (int i = 1; i <= N; i++) {
			edges[i] = new LinkedList<>();
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (A == -1 && B == -1) break;
			
			edges[A].add(B);
			edges[B].add(A);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int[][] score = new int[N + 1][1]; // 회원 별 회장 점수
		boolean[] visited = new boolean[N + 1];
		int min = 987654321; // 회장 점수 최솟값
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			queue.add(i);
			int cnt = -1; // 본인 제외
			
			while (!queue.isEmpty()) {
				int len = queue.size();
				for (int l = 0; l < len; l++) {
					int num = queue.poll();
					
					for (int j = 0; j < edges[num].size(); j++) {
						int next = edges[num].get(j);
						
						if (visited[next]) continue;
						
						visited[next] = true;
						queue.add(next);
					}
				}
				cnt++;
			}
			score[i][0] = cnt; // 회원별 회장 점수
			min = Math.min(min, cnt); // 회장 점수 구하기
		}
		
		sb.append(min).append(" "); // 회장 점수 담기
		
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) { // 회장 후보 수 구하기
			if (score[i][0] == min) cnt++;
		}
		
		sb.append(cnt).append("\n"); // 회장 후보 수 담기
		
		for (int i = 1; i <= N; i++) { // 회장 후보 담기
			if (score[i][0] == min) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}