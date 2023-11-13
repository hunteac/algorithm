import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] score = new int[N][3];
		int[][] maxdp = new int[N][3];
		int[][] mindp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxdp[0][0] = mindp[0][0] = score[0][0];
		maxdp[0][1] = mindp[0][1] = score[0][1];
		maxdp[0][2] = mindp[0][2] = score[0][2];
		
		for (int i = 1; i < N; i++) {
			maxdp[i][0] = Math.max(maxdp[i - 1][0] + score[i][0], maxdp[i - 1][1] + score[i][0]); 
			maxdp[i][1] = Math.max(maxdp[i - 1][0] + score[i][1], maxdp[i - 1][1] + score[i][1]);
			maxdp[i][1] = Math.max(maxdp[i][1], maxdp[i - 1][2] + score[i][1]);
			maxdp[i][2] = Math.max(maxdp[i - 1][1] + score[i][2], maxdp[i - 1][2] + score[i][2]); 
			mindp[i][0] = Math.min(mindp[i - 1][0] + score[i][0], mindp[i - 1][1] + score[i][0]); 
			mindp[i][1] = Math.min(mindp[i - 1][0] + score[i][1], mindp[i - 1][1] + score[i][1]);
			mindp[i][1] = Math.min(mindp[i][1], mindp[i - 1][2] + score[i][1]);
			mindp[i][2] = Math.min(mindp[i - 1][1] + score[i][2], mindp[i - 1][2] + score[i][2]); 
		}
		
		int max = Math.max(maxdp[N - 1][0], maxdp[N - 1][1]);
		max = Math.max(max, maxdp[N - 1][2]);
		
		int min = Math.min(mindp[N - 1][0], mindp[N - 1][1]);
		min = Math.min(min, mindp[N - 1][2]);
		
		System.out.println(max + " " + min);
	}
}
