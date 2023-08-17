import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stk1 = new Stack<>();
			Stack<Integer> stk2 = new Stack<>();
			StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();
			String s = sc.next();
			// 스택을 활용하여 전위표기법을 후위표기법으로 변환
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!(Character.isDigit(c))) { 
					if (stk1.isEmpty()) {
						stk1.push(c);
					} else {
						if (priority(stk1.peek()) < priority(c)) // top에 있는 연산자보다 우선순위가 높으면 push 한다.
							stk1.push(c);
						else if (c != ')') { 
							// top에 있는 연산자보다 우선순위가 낮거나 같으면 높을때까지 스택에 있는 연산자들을 pop하여 출력한다.
							while (priority(stk1.peek()) >= priority(c)) { 
								if (c == '(') break;; // 여는 괄호는 우선순위에 상관없이 스택에 push 한다.
								sb.append(stk1.pop());
								if (stk1.isEmpty())
									break;
							}
							stk1.push(c);
						}
					}
					if (c == ')') { // 닫는 괄호가 등장하면 여는 괄호가 등장할 때 까지 스택에 있는 연산자들을 pop하고 출력한다.
						while (true) {
							if (stk1.peek() == '(') {
								stk1.pop(); // 여는 괄호는 출력하지 않고 pop만 한다.
								break;
							} else
								sb.append(stk1.pop());
						}
					}
				} else {
					sb.append(c); // 피연산자들은 출력
				}
			}
			while (!(stk1.isEmpty())) { // 스택에 남아있는 연산자들을 모두 출력
				sb.append(stk1.pop());
			}
			// 후위표기법 계산
			int sum = 0;
			for (int i = 0; i < sb.length(); i++) {
				if (Character.isDigit(sb.charAt(i))) {
					stk2.push((int) sb.charAt(i) - 48);
				} else {
					int a = stk2.pop(); // top에 위치한 피연산자
					int b = stk2.pop();
					if (sb.charAt(i) == '+') sum = b + a; // top에 위치한 피연산자를 뒤쪽에 위치
					if (sb.charAt(i) == '-') sum = b - a; // 위와 동일
					if (sb.charAt(i) == '*') sum = b * a; // 위와 동일
					if (sb.charAt(i) == '/') sum = b / a; // 위와 동일
					stk2.push(sum);
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
	// 연산자들의 우선순위를 비교하기 위한 메소드 생성
	public static int priority (char c) {
		int num = 0;
		switch(c) {
		case '+': 
			num = 1;
			break;
		case '-': 
			num = 1;
			break;
		case '*':
			num = 2;
			break;
		case '/':
			num = 2;
			break;
		case '(':
			num = 0;
			break;
			}
		return num;
	}
}	