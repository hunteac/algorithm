import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
        	 // 정수를 저장하는 스택 선언
            Stack<Character> stack = new Stack<>();
        	String str = br.readLine();
        	// 괄호의 개수가 홀수이면 올바른 괄호 문자열이 될 수 없다.
        	if (str.length() % 2 != 0) {
        		sb.append("NO").append("\n");
        		continue;
        	}
        	int cnt = 0;
        	for (int i = 0; i < str.length(); i++) {
        		if (str.charAt(i) == '(')
        			stack.push(str.charAt(i));
        		else { 
        			if (!stack.isEmpty()) {
        				stack.pop();
        				cnt++;
        			}
        		}
        	}
        	// 괄호 짝의 개수가 맞다면 올바른 괄호 문자열이다.
        	if (cnt == str.length() / 2)
        		sb.append("YES").append("\n");
        	else
        		sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}