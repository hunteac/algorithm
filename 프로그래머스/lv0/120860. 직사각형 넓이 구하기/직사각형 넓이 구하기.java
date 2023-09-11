class Solution {
    public int solution(int[][] dots) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            x = Math.max(x, Math.abs(dots[i][0] - dots[i + 1][0])); // 가로 길이
            y = Math.max(y, Math.abs(dots[i][1] - dots[i + 1][1])); // 세로 길이
        }
        return x * y;
    }
}