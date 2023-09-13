class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) answer += absolutes[i]; // 양수 더하기
            else answer -= absolutes[i]; // 음수 더하기
        }
        return answer;
    }
}