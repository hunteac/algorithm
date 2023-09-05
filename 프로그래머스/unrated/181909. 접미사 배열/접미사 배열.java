import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()]; // 접미사 수만큼의 길이를 가진 배열 선언
        for (int i = 0; i < answer.length; i++) {
            answer[i] = my_string.substring(i, my_string.length()); // 모든 접미사 담기   
        }
        Arrays.sort(answer); // 사전순으로 정렬
        return answer;
    }
}