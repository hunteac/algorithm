import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] tmp = myString.split("x"); // 문자열을 x 기준으로 자르기
        int cnt = 0; 
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals("")) cnt++; // 공백 개수 구하기
        }
        String[] answer = new String[tmp.length - cnt]; // 출력 배열 선언
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("")) answer[cnt++] = tmp[i]; // 공백이 아닌 문자열 담기
        }
        Arrays.sort(answer); // 사전순으로 정렬
        return answer;
    }
}