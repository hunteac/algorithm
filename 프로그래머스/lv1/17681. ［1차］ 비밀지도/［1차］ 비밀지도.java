import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]); // 비트연산자를 사용한 후 이진법을 문자열로 변환
        }
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", answer[i]); // 공백 채우기
            answer[i] = answer[i].replace("1", "#"); // 1은 "#"
            answer[i] = answer[i].replace("0", " "); // 0은 공백
        }
        return answer;
    }
}