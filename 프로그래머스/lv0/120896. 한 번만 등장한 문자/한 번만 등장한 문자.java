import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<String> list = new ArrayList<>();
        int[] ASCII = new int[123]; // 아스키코드 배열 선언
        for (int i = 0; i < s.length(); i++) {
            ASCII[s.charAt(i)]++; // 각각의 문자 등장 횟수 구하기
        }
        for (int i = 97; i < 123; i++) {
            if (ASCII[i] == 1) {
                char c = (char) i; // 숫자 -> 문자 변환
                list.add(String.valueOf(c)); // 문자 -> 문자열 변환
            } 
        }
        Collections.sort(list); // 오름차순 정렬
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }
}