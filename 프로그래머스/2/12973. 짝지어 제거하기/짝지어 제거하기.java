import java.util.*;

class Solution {
    
    public int solution(String s) {
        Stack<Character> str = new Stack<>();
        
        if (s.length() % 2 == 1) return 0; // 홀수는 짝을 지을 수 없다.
        
        for (int i = 0; i < s.length(); i++) {
            if (str.isEmpty()) { // 스택 공백
                str.add(s.charAt(i));
            } else {
                if (str.peek() == s.charAt(i)) str.pop(); // 짝 짓기
                else str.add(s.charAt(i)); // 짝을 지을 수 없다
            }
        }
        
        if (str.isEmpty()) return 1;
        else return 0;
    }
}