import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			Queue<Integer> queue = new LinkedList<>();
			// 붕어빵을 먹을 수 있는 사람 수
			int N = sc.nextInt();
			// 붕어빵을 만드는 시간
			int M = sc.nextInt();
			// 시간동안 만들 수 있는 붕어빵 개수
			int K = sc.nextInt();
			// 출력 기본값을 불가능으로 지정
			String answer = "Impossible";
			// 입력받은 시간마다 생성된 붕어빵 개수를 담는 배열 선언
			int[] p = new int[N];
			for (int i = 0; i < N; i++) {
				int time = sc.nextInt();
				p[i] = time / M * K;
			}
			// 오름차순 정렬
			Arrays.sort(p);
			for (int i = 0; i < N; i++) {
				queue.add(p[i]);
			}
			int cnt = 0;
			// 꺼낸 붕어빵 개수를 위한 변수 선언 및 초기화
			int fb = 1;
			while (cnt <= N) {
				// 큐가 비었다면 반복문 종료
				if (queue.isEmpty())
					break;
				// 큐에서 생성된 붕어빵 개수 꺼내기
				int num = queue.poll();
				// 생성된 붕어빵이 꺼낸 붕어빵 개수보다 많거나 같다면
				if (num - fb >= 0) {
					// 꺼낸 붕어빵 개수 증가
					fb++;
					// cnt 증가
					cnt++;
				} else {
					break;
				}
				// cnt가 사람 수와 같다면 붕어빵을 제공할 수 있다.
				if (cnt == N)
					answer = "Possible";
			}
			System.out.println("#" + test_case + " " + answer);
		}
    }
}