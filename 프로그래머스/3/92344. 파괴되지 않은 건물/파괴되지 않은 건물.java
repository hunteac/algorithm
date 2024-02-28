class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        
        int[][] sum = new int[N + 1][M + 1]; // 누적합 배열
        
        for (int r = 0; r < skill.length; r++) {
            int startR = skill[r][1]; // 시작
            int startC = skill[r][2];
            int endR = skill[r][3]; // 끝
            int endC = skill[r][4];
                
            if (skill[r][0] == 1) { // 공격
                sum[startR][startC] -= skill[r][5];
                sum[endR + 1][endC + 1] -= skill[r][5];
                sum[startR][endC + 1] += skill[r][5];
                sum[endR + 1][startC] += skill[r][5];
            } else { // 회복
                sum[startR][startC] += skill[r][5];
                sum[endR + 1][endC + 1] += skill[r][5];
                sum[startR][endC + 1] -= skill[r][5];
                sum[endR + 1][startC] -= skill[r][5];
            }
        }

        // 열 누적합 구하기
        for (int r = 0; r < N + 1; r++) {
            for (int c = 0; c < M; c++) {
                sum[r][c + 1] += sum[r][c];
            }
        }
        
        // 행 누적합 구하기 
        for (int c = 0; c < M + 1; c++) {
            for (int r = 0; r < N; r++) {
                sum[r + 1][c] += sum[r][c];
            }
        }
        
        // 누적합 배열을 활용해서 건물 상태 확인
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] + sum[r][c] > 0) answer++; // 파괴되지 않은 건물
            }
        }
        
        return answer;
    }
}