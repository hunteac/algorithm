import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char c : s.toCharArray()) {
            for (int i = index; i > 0; i--) { // 알파벳 바꾸기
                c++;
                if (c > 122) c -= 26;
                while (skip.contains(String.valueOf(c))) { // skip에 있는 알파벳은 제외
                    c++;
                    if (c > 122) c -= 26;
                }
            }
            answer += c;
        }
        return answer;
    }
}