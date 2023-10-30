import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] people = new int[N][2];
		int[] rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			people[i][1] = Integer.parseInt(st.nextToken()); // 키
			rank[i] = 1; // 등수
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				
				// 덩치가 더 큰 사람이면 등수 +1
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) rank[i]++;
			}
		}
		
		for (int n : rank) sb.append(n).append(" ");
		
		System.out.println(sb);
	}
}