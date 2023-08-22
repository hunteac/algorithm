import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 암호문을 담을 연결 리스트 생성
			LinkedList<Integer> list = new LinkedList<>();
			// 원본 암호문 뭉치 속 암호문의 개수
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			// 명령어 개수 입력
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				// 명령어에 존재하는 I 입력
				String s = sc.next();
				// I(삽입)
				if (s.equals("I")) {
					// 숫자들을 입력받을 위치 입력
					int plc = sc.nextInt();
					// 해당 위치에 넣을 숫자 개수 입력
					int nums = sc.nextInt();
					for (int j = 0; j < nums; j++) {
						// plc 위치에 nums 개수 숫자 삽입
						list.add(plc++, sc.nextInt());
					}
				// D(삭제)
				} else if (s.equals("D")) {
					// 암호문을 삭제할 위치 입력
					int plc = sc.nextInt();
					// 삭제할 암호문 개수
					int nums = sc.nextInt();
					for (int j = 0; j < nums; j++) {
						list.remove(plc);
					}
				// A(추가)
				} else {
					// 덧붙일 암호문 개수
					int nums = sc.nextInt();
					// 리스트 맨 뒤에 암호문 덧붙이기
					for (int j = 0; j < nums; j++) {
						list.addLast(sc.nextInt());
					}
				}
			}
			// 수정된 암호문 숫자 10개 출력
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
    }
}