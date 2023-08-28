import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> cards = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			cards.add(i + 1);
		}
		while (cards.size() > 1) { // 한 장 남을때까지 반복문 실행
			cards.poll(); // 카드 버리기
			cards.add(cards.poll()); // 제일 위에 있는 카드 제일 아래에 놓기
		}
		System.out.println(cards.peek());
	}
}