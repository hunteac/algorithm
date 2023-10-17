import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 학생 수 
		int m = Integer.parseInt(st.nextToken()); // 학생 순서 수
		
		ArrayList<Integer>[] lists = new ArrayList[n + 1];
		
		int[] nums = new int[n + 1]; // 앞에 서야하는 학생 수
		
		for (int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); // 앞 학생
			int Y = Integer.parseInt(st.nextToken()); // 뒤 학생
			
			lists[X].add(Y);
			
			nums[Y]++; // 학생 별 앞에 서야하는 학생 수
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (nums[i] == 0) queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 현재 학생
			
			for (int i = 0; i < lists[curr].size(); i++) {
				int next = lists[curr].get(i);
				// 더이상 앞에 서야하는 학생이 없으면 큐에 넣기
				if (--nums[next] == 0) queue.add(next); 
			}
			
			sb.append(curr).append(" "); // 줄 세우기
		}
		
		System.out.println(sb);
	}
}
