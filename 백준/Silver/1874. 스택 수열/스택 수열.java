import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int curr = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean chk = false;

            if (curr <= num) {
                for (int j = curr; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                curr = num + 1;
            } else {
                while (!stack.isEmpty()) {
                    int next = stack.pop();
                    sb.append("-").append("\n");
                    if (next == num) {
                        chk = true;
                        break;
                    }
                }
                if (!chk && stack.isEmpty()) { // 불가능한 경우
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.print(sb);
    }
}