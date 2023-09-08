class Solution {
    public int solution(int a, int b) {
        if (a % 2 == 1 && b % 2 == 1) return (int) (Math.pow(a, 2) + Math.pow(b, 2)); // 모두 홀수라면
        else if (a % 2 == 1 || b % 2 == 1) return 2 * (a + b); // 둘 중 하나만 홀수라면
        else return Math.abs(a - b); // 모두 홀수라면
    }
}