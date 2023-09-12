class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        for (int i = -100; i < 100; i++) {
            int line = 0;
            if (lines[0][0] <= i && lines[0][1] > i) line++;
            if (lines[1][0] <= i && lines[1][1] > i) line++;
            if (lines[2][0] <= i && lines[2][1] > i) line++;
            if (line > 1) answer++; // 겹치는 선분 길이 더하기
        }
        return answer;
    }
}