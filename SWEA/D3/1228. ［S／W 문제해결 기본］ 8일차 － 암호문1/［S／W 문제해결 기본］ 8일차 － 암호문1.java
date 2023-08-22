import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 암호문을 담을 연결 리스트 생성
			LinkedList<Integer> list = new LinkedList<>();
			// 원본 암호문 길이 입력
			int len = sc.nextInt();
			for (int i = 0; i < len; i++) {
				list.add(sc.nextInt());
			}
			// 명령어 개수 입력
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				// 명령어에 존재하는 I 입력
				String s = sc.next();
				// 숫자들을 입력받을 위치 입력
				int plc = sc.nextInt();
				// 해당 위치에 넣을 숫자 개수 입력
				int nums = sc.nextInt();
				for (int j = 0; j < nums; j++) {
					// plc 위치에 nums 개수 숫자 삽입
					list.add(plc++, sc.nextInt());
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