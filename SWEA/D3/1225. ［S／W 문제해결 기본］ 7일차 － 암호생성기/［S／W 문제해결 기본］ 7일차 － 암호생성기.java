import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			// 큐를 사용하기 위한 LinkedList 구현 클래스를 활용
			Queue<Integer> pwd = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				pwd.add(sc.nextInt());
			}
			int minus = 1;
			Outer: while (true) {
				for (int i = 0; i < 5; i++) {
					// 감소시킬 수 큐에서 삭제
					int num = pwd.poll();
					num -= minus++;
					// 감소한 숫자가 0보다 작거나 같으면 반복문 종료
					if (num <= 0) {
						pwd.add(0);
						break Outer;
					}
					// 감소시킨 수 다시 큐에 삽입
					pwd.add(num);
				}
				minus = 1;
			}
			System.out.print("#" + n + " ");
			for (int i : pwd) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}	
}	