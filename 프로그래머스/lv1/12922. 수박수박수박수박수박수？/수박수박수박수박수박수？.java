class Solution {
    public String solution(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) answer += "수"; // 짝수 인덱스 = 수
            else answer += "박"; // 홀수 인덱스 = 박
        }
        return answer;
    }
}