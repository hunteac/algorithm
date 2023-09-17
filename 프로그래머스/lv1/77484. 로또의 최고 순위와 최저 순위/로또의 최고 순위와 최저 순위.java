import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0; // 0 개수
        int sameCnt = 0; // 당첨 번호 개수
        for (int i = 0; i < lottos.length; i++) { // 개수 구하기
            if (lottos[i] == 0) zeroCnt++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) sameCnt++;
            }
        }
        if (7 - (zeroCnt + sameCnt) < 6) {
            answer[0] = 7 - (zeroCnt + sameCnt);
            if (zeroCnt == 6) answer[1] = 6;
            else answer[1] = 7 - (sameCnt);
        } 
        else {
            answer[0] = answer[1] = 6;
        } 
        return answer;
    }
}