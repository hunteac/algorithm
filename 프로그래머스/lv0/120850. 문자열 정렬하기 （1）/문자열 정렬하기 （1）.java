import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) >= 48 && my_string.charAt(i) <= 57) answer.add(my_string.charAt(i) - 48); // 숫자만 담기
        }
        Collections.sort(answer); // 리스트 오름차순 정렬
        return answer.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 변환
    }
}