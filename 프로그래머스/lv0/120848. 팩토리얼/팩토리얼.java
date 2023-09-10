class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        int cnt = 2;
        while (num <= n) {
            num *= cnt++;
            answer++;
        }
        return answer;
    }
}