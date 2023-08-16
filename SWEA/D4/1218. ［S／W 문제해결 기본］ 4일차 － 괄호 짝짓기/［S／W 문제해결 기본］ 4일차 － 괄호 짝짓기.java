import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '[' || // 여는 괄호가 나오면 스택에 삽입 
						c == '{' || c == '<')    
					stack.push(c);
				// 닫는 괄호가 나오면 마지막으로 삽입된 문자와 비교하여 동일한 종류의 괄호면
				// pop 메소드를 통해 빼내고 cnt +1 
				else {
					if (c == ')' && stack.peek().equals('(')) { 
						stack.pop();
						cnt++;
					}
					if (c == ']' && stack.peek().equals('[')) {
						stack.pop();
						cnt++;
					}
					if (c == '}' && stack.peek().equals('{')) { 
						stack.pop();
						cnt++;
					}
					if (c == '>' && stack.peek().equals('<')) {
						stack.pop();
						cnt++;
					}
				}
			}
			// 유효한 괄호들로 문자열이 구성돼있으면 cnt의 개수가 n / 2이기 때문에 1출력
			if (cnt == n / 2) System.out.println("#" + test_case + " " + 1);
			else System.out.println("#" + test_case + " " + 0);
		}
	}
}