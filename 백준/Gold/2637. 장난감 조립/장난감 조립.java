import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Part { // 부품 객체
		int Y;
		int K;
		public Part(int y, int k) {
			Y = y;
			K = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 부품 개수 
		int m = Integer.parseInt(br.readLine()); // 부품 관계 개수
		
		ArrayList<Part>[] lists = new ArrayList[n + 1];
		
		int[] nums = new int[n + 1]; // 부품별 선행작업 수
		int[] cnt = new int[n + 1]; // 필요한 기본 부품 개수
		boolean[] chk = new boolean[n + 1]; // 기본 부품 확인
		
		for (int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<>();
			chk[i] = true;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			chk[X] = false; // 중간 부품
			
			lists[X].add(new Part(Y, K));
			
			nums[Y]++; // 부품별 선행 작업 수
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(n); // 최종 완제품
		
		cnt[n] = 1;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 현재 부품
			
			for (int i = 0; i < lists[curr].size(); i++) {
				int next = lists[curr].get(i).Y; // 다음 부품
				if (--nums[next] == 0) queue.add(next); // 선행 작업 완료시 큐에 넣기
				cnt[next] += lists[curr].get(i).K * cnt[curr]; // 필요한 부품 개수 더하기
			}
		}
		
		// 기본 부품 오름차순
		for (int i = 1; i <= n; i++) {
			if (chk[i]) sb.append(i + " " + cnt[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
