import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            if (list.contains(my_string.charAt(i))) continue; // 중복 문자 제거
            list.add(my_string.charAt(i));
            answer += my_string.charAt(i);
        }
        return answer;
    }
}