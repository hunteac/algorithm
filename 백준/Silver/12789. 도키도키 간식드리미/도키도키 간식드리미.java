import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 학생들의 수
		int num = Integer.parseInt(br.readLine());
		// 번호표를 가진 학생들을 담는 배열 생성
		int[] line = new int[num];
		// 한 명씩 설 수 있는 임시 공간
		Stack<Integer> tmpspc = new Stack<>();
		st = new StringTokenizer(br.readLine());
		// 학생들 배열에 담기
		for (int i = 0; i < num; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		// 기본 출력값 = "Sad"
		String answer = "Sad";
		// 번호표 순서 변수
		int order = 1;
		// 번호표 순서대로 간식 나눠주기
		for (int i = 0; i < num; i++) {
			// 학생 번호가 순서보다 크다면 임시 공간으로 보내기
			if (line[i] > order) {
				tmpspc.push(line[i]);
			// 학생 번호가 순서와 같다면 간식을 받고 다음 순서 진행
			} else if (line[i] == order) {
				order++;
				// 임시 공간에 학생이 존재하고 학생의 번호가 순서와 같다면 간식을 받고 다음 순서 진행
				while (!tmpspc.isEmpty() && tmpspc.peek() == order) {
					tmpspc.pop();
					order++;
				}
			}
		}
		// 모든 사람이 간식을 받았다면
		if (order > num)
			// 출력 값 = "Nice"
			answer = "Nice";
		System.out.println(answer);
	}
}