import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = { 1, 2, 3, 4, 5 }; // 1번 방식
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 2번 방식
        int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 3번 방식
        int[] scores = new int[3]; // 번호별 점수
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < answers.length; i++) { // 정답 확인
            if (answers[i] == one[i % 5]) scores[0]++;
            if (answers[i] == two[i % 8]) scores[1]++;
            if (answers[i] == three[i % 10]) scores[2]++;
            for (int j = 0; j < scores.length; j++) { // 최대 점수 구하기
                max = Math.max(max, scores[j]);
            }
        }
        for (int i = 0; i < scores.length; i++) { // 최대 점수를 맞은 학생 오름차순 정렬
            if (scores[i] == max) list.add(i + 1);
        }
        return list.stream().mapToInt(i -> i).toArray(); // 리스트 -> 배열 변환
    }
}