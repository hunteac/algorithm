import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int[] tmp = new int[arr.length];
        int[] one = { -1 };
        if (arr.length == 1) return one; // arr 길이가 1인 경우 -1 반환
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }    
        Arrays.sort(tmp);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tmp[0]) answer[idx++] = arr[i]; // 가장 작은 수를 제외한 수 배열에 담기
        }
        return answer;
    }
}