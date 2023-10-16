import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
		
		int cnt = 1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (find(A) == find(B)) {
				System.out.println(cnt);
				return;
			} else {
				union(A, B);
				cnt++;
			}
		}
		
		System.out.println(0);
	}
	
	static int find (int x) {
		if (x == p[x]) return x;
		else return p[x] = find(p[x]);
	}
	
	static void union (int A, int B) {
		A = p[A];
		B = p[B];
		if (A != B) p[A] = find(B);
	}
}
