class Solution {
    public int solution(int balls, int share) {
        if (balls == share) return 1;
        long answer = 1;
        int n = Math.min(share, balls - share);
        for (int i = 1; i <= n; i++) { // 조합
            answer *= (long) balls--;
            answer /= (long) i;
        }
        return (int) answer;
    }
}