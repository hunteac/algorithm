import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) { // 연속되는 수 지우기
                arr[i] = -1;
                cnt++;
            } 
        }
        int[] answer = new int[arr.length - cnt];
        cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) answer[cnt++] = arr[i]; // 순서 유지한채로 출력 배열에 담기
        }
        return answer;
    }
}