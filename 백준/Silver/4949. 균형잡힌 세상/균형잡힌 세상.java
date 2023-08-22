import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			// 왼쪽 괄호들을 담을 스택 생성
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			// 온점 하나를 입력받으면 입력 종료
			if (s.equals("."))
				break;
			// 기본 출력값을 "yes"로 지정
			String answer = "yes";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				// 왼쪽 괄호는 스택에 집어 넣기
				if (c == '(' || c == '[') {
					stack.push(c);
				}
				if (c == ')') {
					// 스택이 비어있거나 괄호짝이 맞지 않는다면
					if (stack.isEmpty() || stack.pop() != '(') {
						// 출력값 = "no"
						answer = "no";
						break;
					}
				} else if (c == ']') {
					// 스택이 비어있거나 괄호짝이 맞지 않는다면
					if (stack.isEmpty() || stack.pop() != '[') {
						// 출력값 = "no"
						answer = "no";
						break;
					}
				}
			}
			// 반복문이 끝났는데도 스택이 비어있지 않다면
			if (!stack.isEmpty())
				// 출력값 = "no"
				answer = "no";
			System.out.println(answer);
		}
	}
}