import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0; // 회차
        int num = 0; // 제거한 0 개수
        int sum = 0; // 총 개수
        
        String tmp = "";
        
        while (!s.equals("1")) {
            num = 0;
            tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') tmp += "1";
                else num++; // 0 제거
            }
            s = Integer.toBinaryString(tmp.length()); // 이진 변환
            sum += num;
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = sum;
        
        return answer;
    }
}