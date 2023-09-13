class Solution {
    public int solution(int[][] dots) {
        int x, y, x2, y2 = 0;
        int answer = 0;
        for (int i = 1; i < 4; i++) { // 두 직선이 평행이 되려면 각 좌표들의 x, y값의 차의 절댓값이 같아야 한다.
            x = Math.abs(dots[0][0] - dots[i][0]);
            y = Math.abs(dots[0][1] - dots[i][1]);
            if (i == 1) {
                x2 = Math.abs(dots[2][0] - dots[3][0]);
                y2 = Math.abs(dots[2][1] - dots[3][1]);
            } else if (i == 2) {
                x2 = Math.abs(dots[1][0] - dots[3][0]);
                y2 = Math.abs(dots[1][1] - dots[3][1]);
            } else {
                x2 = Math.abs(dots[1][0] - dots[2][0]);
                y2 = Math.abs(dots[1][1] - dots[2][1]);
            }
            if ((x == x2 && y == y2) || ((double) x / y) == ((double) x2 / y2)) { // 두 직선이 겹치는 경우도 포함
                answer++;
                break;
            } 
        }
        return answer;
    }
}