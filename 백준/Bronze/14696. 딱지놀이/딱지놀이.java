import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 라운드 수
		for (int tc = 1; tc <= T; tc++) {
			int[] A = new int[5]; // A가 가지고 있는 딱지
			int[] B = new int[5]; // B가 가지고 있는 딱지
			st = new StringTokenizer(br.readLine());
			int anum = Integer.parseInt(st.nextToken());// A가 가지고 있는 딱지 수
			for (int i = 0; i < anum; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int bnum = Integer.parseInt(st.nextToken()); // B가 가지고 있는 딱지 수	
			for (int i = 0; i < bnum; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			for (int i = 4; i >= 1; i--) { 
				if (A[i] > B[i]) { // 딱지 비교
					sb.append("A").append("\n");
					break;
				} else if (A[i] < B[i]) {
					sb.append("B").append("\n");
					break;
				}
				if (i == 1 && A[i] == B[i])
					sb.append("D").append("\n");
			}
		}
		System.out.println(sb);
	}
}