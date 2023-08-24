import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static String[] tree;
	public static int[] left;
	public static int[] right;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 트리가 갖는 정점의 총 수
			int N = Integer.parseInt(br.readLine());
			// 노드 값을 담기 위한 트리 배열 선언
			tree = new String[N + 1];
			// 왼쪽 자식을 담기 위한 배열 선언
			left = new int[N + 1];
			// 오른쪽 자식을 담기 위한 배열 선언
			right = new int[N + 1];
			// 트리 채우기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				if (st.hasMoreTokens()) {
					left[t] = Integer.parseInt(st.nextToken());
					right[t] = Integer.parseInt(st.nextToken());
				}
				tree[t] = str;
			}
			// 루트 정점 번호를 1번으로 시작하는 재귀 함수 값 출력
			System.out.println("#" + test_case + " " + (int) recurr(1));
		}
    }
	// 재귀 함수 생성
	public static double recurr (int i) {
		// 재귀 깊이가 들어가지 않는 조건		
		if (left[i] == 0) {
			return Double.parseDouble(tree[i]);
		}
			// 재귀 깊이 + 1
			double a = recurr(left[i]); // 왼쪽 자식 탐색
			double b = recurr(right[i]); // 오른쪽 자식 탐색
			// 정점이 연산자라면 연산 수행
			if (tree[i].equals("+")) { 
				return a + b;
			} else if (tree[i].equals("-")) {
				return a - b;
			} else if (tree[i].equals("*")) {
				return a * b;
			} else if (tree[i].equals("/")) {
				return a / b;
			}
		return 0;
	}
}