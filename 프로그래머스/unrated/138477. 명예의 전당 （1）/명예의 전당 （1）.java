import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>(); // 명예의 전당
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list, (o1, o2) -> (o2 - o1)); // 내림차순 정렬
            if (list.size() < k) answer[i] = list.get(list.size() - 1); // 최하위 점수 발표
            else answer[i] = list.get(k - 1);
        }
        return answer;
    }
}