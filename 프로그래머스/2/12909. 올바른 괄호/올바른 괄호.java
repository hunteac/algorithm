import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 여는 괄호 넣기
                stack.add('(');
            } else { // 닫는 괄호
                if (stack.isEmpty()) { // 스택이 비어있다면
                    answer = false; // 올바르지 않은 괄호
                    break;
                } else {
                    stack.pop(); // 여는 괄호 꺼내기
                }
            }
        }
        
        if (!stack.isEmpty()) return false; // 여는 괄호가 남아있는 경우
        else return answer;
    }
}