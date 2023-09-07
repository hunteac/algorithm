import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        int cnt = 0;
        myStr = myStr.replace("a", " "); // a를 공백으로 변환
        myStr = myStr.replace("b", " "); // b를 공백으로 변환
        myStr = myStr.replace("c", " "); // c를 공백으로 변환
        String[] tmp = myStr.split(" "); 
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("")) cnt++;
        }
        if (cnt == 0) cnt = 1;
        String[] answer = new String[cnt]; // 배열 선언
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i].equals("")) answer[cnt++] = tmp[i]; // 배열에 문자열 담기
        }
        if (cnt == 0) answer[0] = "EMPTY"; // 배열이 비었다면 EMPTY 담기
        return answer;
    }
}