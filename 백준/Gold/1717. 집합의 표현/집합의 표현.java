import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int chk = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (chk == 0) {
				union(a, b);
				continue;
			}
			
			if (find(a) == find(b)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	static int find(int x) {
		if (x == p[x]) return x;
		else return p[x] = find(p[x]);
	}
	
	static void union(int x, int y) {
		int A = find(x);
		int B = find(y);
		
		if (A != B) p[A] = find(B);
	}
}
