import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			int[][] snl = new int[len][len];
			// 달팽이 배열에 들어갈 숫자 변수 선언 및 초기화
			int num = 0;
			// 행과 열 순회 방향을 바꾸기 위한 변수 선언 및 초기화
			int rc = 0;
			// rc가 증가할 때 바뀌는 규칙을 적용시키기 위한 변수 선언 및 초기화
			int cnt = 0;
			// 나선형 모양으로 순회하며 배열에 값 추가
			for (int i = 0; i < len; i++) {
				cnt = (rc / 2) + 1;
				// 열 순회
				for (int j = rc; j < len; j++) {
					num++;
					if (rc == 0) {
						snl[rc][j] = num;
					} else {
						if (rc % 2 == 1) { // 위에서 아래로
							snl[cnt][len - (rc + 1) / 2] = num;
						} else { // 아래에서 위로
							snl[len - cnt][rc / 2 - 1] = num;
						}
						cnt++;
					}
				}
				cnt = (rc / 2) + 1;
				// 행 순회
				if (rc != 0) {
					for (int j = rc; j < len; j++) {
						num++;
						if (rc % 2 == 1) { // 왼쪽에서 오른쪽으로
							snl[len - (rc + 1) / 2][len - cnt - 1] = num;
						} else { // 오른쪽에서 왼쪽으로
							snl[rc / 2][cnt - 1] = num;
						}
						cnt++;
					}
				}
				rc++;
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					System.out.print(snl[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}