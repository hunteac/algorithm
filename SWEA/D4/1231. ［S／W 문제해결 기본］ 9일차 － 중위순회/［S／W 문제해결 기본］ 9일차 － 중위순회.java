import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 트리가 갖는 정점의 총 수
			int N = Integer.parseInt(sc.nextLine());
			// 정점의 총 수를 크기로 갖는 배열 선언
			char[] tree = new char[N + 1];
			// 트리 채우기
			for (int i = 1; i <= N; i++) {
				String s = sc.nextLine();
				char c = s.charAt(0);
				int idx = 1;
				// 문자열 s에서 트리에 넣을 문자를 찾을 때까지 반복문 실행
				while (Character.isDigit(c) || c == ' ') {
					c = s.charAt(idx++);
				}
				tree[i] = c;
			}
			// 중위 순회 메소드를 사용하여 출력
			System.out.print("#" + test_case + " ");
			inorder(1, N, tree);
			System.out.println();
		}
    }
	// 중위 순회 메소드 구현
	public static void inorder(int i, int N, char[] arr) {
		if (i <= N) {
			inorder(i * 2, N, arr); // 왼쪽 자식 노드로 이동
			if (arr[i] != 0) {
				System.out.print(arr[i]); // 방문 노드 출력
			}
			inorder(i * 2 + 1, N, arr); // 오른쪽 자식 노드로 이동
		}
	}
}