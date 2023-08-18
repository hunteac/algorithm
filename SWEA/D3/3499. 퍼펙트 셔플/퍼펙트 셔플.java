import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			// 퍼펙트 셔플 후 전체 카드를 담을 큐
			Queue<String> card = new LinkedList<>();
			// 퍼펙트 셔플을 하기 위한 임시 큐 선언
			Queue<String> tmpCard1 = new LinkedList<>();
			Queue<String> tmpCard2 = new LinkedList<>();
			for (int i = 0; i < (n + 1) / 2; i++) {
				tmpCard1.add(sc.next());
			}
			for (int i = 0; i < n / 2; i++) {
				tmpCard2.add(sc.next());
			}
			// 퍼펙트 셔플
			for (int i = 0; i < (n + 1) / 2; i++) {
				card.add(tmpCard1.poll());
				if (!(tmpCard2.isEmpty()))
					card.add(tmpCard2.poll());
			}
			System.out.print("#" + test_case + " ");
			for (String s : card) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}	
}	