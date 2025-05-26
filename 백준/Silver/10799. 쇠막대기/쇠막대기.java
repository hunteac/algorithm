import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(') {
                stack.add('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') { // 레이저
                    cnt += stack.size();
                } else {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}