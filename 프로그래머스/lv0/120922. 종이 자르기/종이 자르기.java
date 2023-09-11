class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        answer += (M - 1); // 가로 자르기
        answer += M * (N - 1); // 세로 자르기
        return answer;
    }
}