import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int sum = n + m;
			Queue<Integer> card1 = new LinkedList<>();
			Queue<Integer> card2 = new LinkedList<>();
			Queue<Integer> result = new LinkedList<>();
			// 두 카드를 더한 수의 횟수를 구하기 위한 배열 선언
			int[] count = new int[sum + 1];
			for (int i = 1; i <= n; i++) {
				card1.add(i);
			}
			for (int i = 1; i <= m; i++) {
				card2.add(i);
			}
			// 각 카드세트에서 담겨있는 수들을 하나씩 선택해 더하고 해당 수가 등장한 횟수 측정
			for (int i = 0; i < n; i++) {
				int num1 = card1.poll();
				for (int j = 0; j < m; j++) {
					int num2 = card2.poll();
					count[num1 + num2]++;
					card2.add(num2);
				}
				card1.add(num1);
			}
			// 최대 빈도수를 가진 값을 구하기 위한 변수 선언 및 초기화
			int max = -1; 
			for (int i = 0; i < count.length; i++) {
				if (count[i] > max)
					max = count[i];
			}
			// 최대 빈도수를 가진 값들을 result 큐에 삽입
			for (int i = 0; i < count.length; i++) {
				if (count[i] == max)
					result.add(i);
			}
			System.out.print("#" + test_case + " ");
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}	
}	