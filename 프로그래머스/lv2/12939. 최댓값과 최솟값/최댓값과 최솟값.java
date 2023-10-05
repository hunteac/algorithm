import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" "); // 공백으로 구분하기
        
        int min = Integer.MAX_VALUE; // 최솟값
        int max = Integer.MIN_VALUE; // 최댓값
        
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            min = Math.min(min, num); // 최솟값 구하기
            max = Math.max(max, num); // 최댓값 구하기
        }
        
        String answer = ""; // 출력 문자열
        answer += String.valueOf(min) + " ";
        answer += String.valueOf(max);
        return answer;
    }
}