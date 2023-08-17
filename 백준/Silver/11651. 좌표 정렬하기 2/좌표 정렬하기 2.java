import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 람다식을 활용한 2차원 배열 정렬
		Arrays.sort(map, (e1, e2) -> {
				if (e1[1] == e2[1]) {
					return e1[0] - e2[0];
				} else {
					return e1[1] - e2[1];
				}
		});
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}