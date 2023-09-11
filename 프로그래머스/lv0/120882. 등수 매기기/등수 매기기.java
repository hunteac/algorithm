import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int[] tmparr = new int[score.length];
        int[] answer = new int[score.length];
        int order = 1;
        for (int i = 0; i < tmparr.length; i++) {
            tmparr[i] = score[i][0] + score[i][1]; // 두 점수 총합 구하기
            score[i][0] = tmparr[i];
        }
        Arrays.sort(tmparr);
        for (int i = tmparr.length - 1; i >= 0; i--) {
            if (i + 1 < tmparr.length && tmparr[i + 1] == tmparr[i]) { // 공동 등수 처리
                order++;
                continue;
            } 
            for (int j = 0; j < score.length; j++) {
                if (tmparr[i] == score[j][0]) answer[j] = order;
            }
            order++;
        }
        return answer;
    }
}