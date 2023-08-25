import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 스도쿠 퍼즐 생성
			int[][] puz = new int[9][9];
			// 퍼즐에 숫자 넣기
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					puz[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 행렬 탐색을 위한 delta 배열 선언 및 초기화
			int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
			// 기본 출력값 = 1
			int answer = 1;
			// 퍼즐 행렬 탐색
			Out: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (int k = j + 1; k < 9; k++) {
						// 행에 중복된 숫자가 존재하면 0
						if (puz[i][j] == puz[i][k]) {
							answer = 0;
							break Out;
						}
						// 열에 중복된 숫자가 존재하면 0
						if (puz[j][i] == puz[k][i]) {
							answer = 0;
							break Out;
						}
					}
				}
			}
			// delta 배열을 이용한 작은 격자 탐색
			Out: for (int i = 1; i < 9; i += 3) {
				for (int j = 1; j < 9; j += 3) {
					for (int d = 0; d < 8; d++) {
						if (puz[i][j] == puz[i + dr[d]][j + dc[d]]) {
							answer = 0;
							break Out;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}