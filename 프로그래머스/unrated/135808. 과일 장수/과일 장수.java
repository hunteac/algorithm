import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m; // score[i] : 상자 속 사과 중 가장 낮은 점수
        }
        return answer;
    }
}