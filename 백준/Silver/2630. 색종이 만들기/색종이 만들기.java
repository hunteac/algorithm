import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper; // 종이
	static int white; // 하얀색 색종이 개수
	static int blue; // 파란색 색종이 개수
	
	static void check(int r, int c, int n) {
		int sum = 0;
		for (int i = r; i < n + r; i++) {
			for (int j = c; j < n + c; j++) {
				sum += paper[i][j];
			}
		}
		
		// 모두 같은 색으로 칠해져 있는 경우
		if (sum == 0) white++;
		else if (sum == n * n) blue++;
		else { // 종이 4등분
			check(r, c, n / 2);
			check(r + (n / 2), c, n / 2);
			check(r, c + (n /2), n / 2);
			check(r + (n / 2), c + (n / 2), n / 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		white = 0;
		blue = 0;
		
		check(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
}