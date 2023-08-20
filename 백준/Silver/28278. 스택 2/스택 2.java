import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 정수를 저장하는 스택 선언
        Stack<Integer> stack = new Stack<>();
        // 명령 수 입력
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
        	// 명령 입력 받기
        	st = new StringTokenizer(br.readLine());
        	int cmd = Integer.parseInt(st.nextToken());
        	// 1 : 정수 X를 스택에 넣는다.
        	if (cmd == 1) {
        		int num = Integer.parseInt(st.nextToken());
        		stack.push(num);
        	// 2 : 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없으면 -1 출력
        	} else if (cmd == 2) {
        		if (!stack.isEmpty())
        			sb.append(stack.pop()).append("\n");
        		else
        			sb.append(-1).append("\n");
        	// 3 : 스택에 들어있는 정수의 개수 출력
        	} else if (cmd == 3) {
        		sb.append(stack.size()).append("\n");
        	// 4 : 스택이 비어있으면 - 1, 아니면 0 출력
        	} else if (cmd == 4) {
        		if (stack.isEmpty())
        			sb.append(1).append("\n");
        		else 
        			sb.append(0).append("\n");
        	// 5 : 스택에 정수가 있다면 맨 위의 정수 출력
        	} else {
        		if (!stack.isEmpty())
        			sb.append(stack.peek()).append("\n");
        		else
        			sb.append(-1).append("\n");
        	}
        }
        System.out.println(sb);
    }
}