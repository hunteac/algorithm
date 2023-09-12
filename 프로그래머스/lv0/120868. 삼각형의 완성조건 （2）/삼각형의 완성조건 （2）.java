class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int num = Math.abs(sides[1] - sides[0]) + 1;
        while (num < sides[0] + sides[1]) {
            answer++;
            num++;
        }
        return answer;
    }
}