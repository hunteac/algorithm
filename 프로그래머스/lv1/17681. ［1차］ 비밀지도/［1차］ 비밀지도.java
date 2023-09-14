import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Long[] sarr1 = new Long[n];
        Long[] sarr2 = new Long[n];
        for (int i = 0; i < n; i++) {
            sarr1[i] = Long.parseLong(Long.toBinaryString(arr1[i])); // 10진법 -> 2진법
            sarr2[i] = Long.parseLong(Long.toBinaryString(arr2[i])); // 10진법 -> 2진법
            sarr1[i] += sarr2[i]; // 각 원소 더하기
        }
        for (int i = 0; i < n; i++) { // 전체 지도 만들기
            String tmp = "";
            String s = String.valueOf(sarr1[i]);
            for (int j = 0; j < n - s.length(); j++) {
                tmp += " ";
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '0') tmp += "#"; // 0이 아닌 곳은 "#"
                else if (s.charAt(j) == '0') tmp += " "; // 0인 곳은 공백
            }
            answer[i] = tmp;
        }
        return answer;
    }
}