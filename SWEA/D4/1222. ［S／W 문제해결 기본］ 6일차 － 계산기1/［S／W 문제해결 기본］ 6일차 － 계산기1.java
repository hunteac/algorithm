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
						if (!(stk1.peek() == c))
							stk1.push(c);
						else { 
							sb.append(stk1.pop());
							stk1.push(c);
						}
					}
				} else {
					sb.append(c);
				}
			}
			while (!(stk1.isEmpty())) {
				sb.append(stk1.pop());
			}
			// 후위표기법 계산
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (Character.isDigit(sb.charAt(i))) {
					stk2.push((int) sb.charAt(i) - 48);
				} else {
					sum = stk2.pop() + stk2.pop();
					stk2.push(sum);
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}	