import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 정수를 저장하는 스택 선언
        Stack<Integer> stack = new Stack<>();
        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
        	int num = Integer.parseInt(br.readLine());
        	// 0이 아니면 스택에 저장
        	if (num != 0) {
        		stack.push(num);
        	// 0이면 가장 최근에 쓴 수 지우기
        	} else {
        		stack.pop();
        	}
        }
        // 스택에 들어있는 수들 총합 구하기
        int sum = 0;
        int len = stack.size();
        for (int i = 0; i < len; i++) {
        	sum += stack.pop();
        }
        System.out.println(sum);
    }
}