import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < my_string.length(); i++) {
            if (list.contains(my_string.charAt(i) - 48)) answer += my_string.charAt(i) - 48;
        }
        return answer;
    }
}