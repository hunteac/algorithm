import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int heapSize = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 연산 수
			int N = Integer.parseInt(br.readLine());
			// 배열을 통한 힙 구현
			int[] heap = new int[N + 1];
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int ck = Integer.parseInt(st.nextToken());
				if (ck == 1) {
					int num = Integer.parseInt(st.nextToken());
					heapPush(heap, num);
				} else {
					System.out.print(heapPop(heap) + " ");
				}
			}
			System.out.println();
			heapSize = 0;
		}
	}
	// 삽입(내림차순)
	public static void heapPush(int[] heap, int i) {
		heap[++heapSize] = i;
		
		int ch = heapSize;
		int p = ch / 2;
		// 자식 노드가 부모 노드보다 크다면 위치 변경
		while (p > 0 && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			// 트리 위로 올라가기
			ch = p;
			p = ch / 2;
		}
	}
	// 삭제
	public static int heapPop(int[] heap) {
		if (heapSize <= 0)
			return -1;
		int item = heap[1]; // 루트노드
		heap[1] = heap[heapSize--]; // 마지막 값을 루트에 넣기
		
		int p = 1;
		int ch = p * 2;
		// 오른쪽 자식과 왼쪽 자식 크기를 비교하여 큰 값으로 이동
		if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1])
			ch += 1;
		// 자식 노드가 부모 노드보다 크다면 위치 변경
		while (ch <= heapSize && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			// 트리 아래로 내려가기
			p = ch;
			ch = p * 2;
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1])
				ch += 1;
		}
		return item;
	}
}