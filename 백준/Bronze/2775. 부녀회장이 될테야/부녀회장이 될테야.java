import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] apt = new int[15][15]; // 아파트
		
		for (int i = 0; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				if (i == 0) apt[i][j] = j;
				else {
					if (j == 1) apt[i][j] = 1;
					else {
						apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
					}
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(apt[k][n]).append("\n");
		}
		
		System.out.println(sb);
	}
}