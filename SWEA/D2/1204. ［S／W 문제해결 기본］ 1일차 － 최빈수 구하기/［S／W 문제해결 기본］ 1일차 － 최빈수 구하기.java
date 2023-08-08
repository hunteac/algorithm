import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] scr = new int[100]; // 0 ~ 100까지의 점수를 가진 학생 수를 저장할 배열
			int[] stu = new int[1000]; // 1000명의 학생 점수를 저장할 배열
			for (int i = 0; i < 1000; i++) {
				stu[i] = sc.nextInt();

			}
			// 학생 점수를 기반으로 각 점수별 학생 수 계산
			for (int i = 0; i < scr.length; i++) {
				for (int j = 0; j < stu.length; j++) {
					if (stu[j] == i) {
						scr[i]++;
					}
				}
			}
			int max = 0; // 가장 많은 학생 수
			int maxIdx = 0; // 가장 많은 학생 수를 가진 점수
			// 각 점수별 학생 수를 순회하며 가장 많은 학생 수와 해당 점수를 찾기
			for (int i = 0; i < scr.length; i++) {
				if (scr[i] >= max) {
					max = scr[i];
					maxIdx = i;
				}
			}
			System.out.printf("#%d %d\n", n, maxIdx);
		}
		sc.close();
	}
}