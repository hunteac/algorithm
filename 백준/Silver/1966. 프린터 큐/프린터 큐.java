import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Document {
		int num;
		int grade;
		
		Document (int num, int grade) {
			this.num = num;
			this.grade = grade;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 중요도를 기준으로 내림차순하는 우선순위 큐
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Document> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());	
			
			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 순서
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				int grade = Integer.parseInt(st.nextToken());
				pq.add(grade);
				q.add(new Document(i, grade));
			}
			
			int len = pq.size();
			int cnt = 1;
			
			while (true) {
				Document d = q.poll();
				if (d.num == M && d.grade == pq.peek()) break;
				
				if (d.grade < pq.peek()) {
					q.add(d);
				} else if (d.grade == pq.peek()) {
					pq.poll();
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}