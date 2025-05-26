import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int beforeCnt = 0;
        int cnt = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            char curr = str.charAt(i);
            char before = i != 0 ? str.charAt(i - 1) : ' ';

            if (curr == '(') {
                stack.add('(');
                beforeCnt++;
            } else {
                stack.pop();

                if (before == '(') { // 레이저
                    beforeCnt = stack.isEmpty() ? 0 : beforeCnt - 1;
                    cnt += stack.size() + beforeCnt;
                }

                beforeCnt = 0;
            }
        }

        System.out.println(cnt);
    }
}