class Solution {
    static int N, M, cnt;
    // 시계방향 회전
    static boolean rotation(int[][] lock, int[][] key, int startR, int startC, int d) {
        int chk = 0;
        int idx = 0;
        if (d == 0) {
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < M; c++) {
                    int lockR = startR + (idx / M);
                    int lockC = startC + (idx % M);
                    idx++;
                    // 범위를 벗어나거나 돌기끼리 만나면 continue
                    if (lockR < 0 || lockR >= N || lockC < 0 || lockC >= N || r < 0 || r >= M || c < 0 || c >= M) continue;
                    // 돌기끼리 만나면 종료
                    if (lock[lockR][lockC] == 1 && key[r][c] == 1) return false;
                    if (lock[lockR][lockC] == 0 && key[r][c] == 1) chk++;
                }
            }
        } else if (d == 1) {
            for (int c = 0; c < M; c++) {
                for (int r = M - 1; r >= 0; r--) {
                    int lockR = startR + (idx / M);
                    int lockC = startC + (idx % M);
                    idx++;
                    // 범위를 벗어나거나 돌기끼리 만나면 continue
                    if (lockR < 0 || lockR >= N || lockC < 0 || lockC >= N || r < 0 || r >= M || c < 0 || c >= M) continue;
                    // 돌기끼리 만나면 종료
                    if (lock[lockR][lockC] == 1 && key[r][c] == 1) return false;
                    if (lock[lockR][lockC] == 0 && key[r][c] == 1) chk++;
                }
            }
        } else if (d == 2) {
            for (int r = M - 1; r >= 0; r--) {
                for (int c = M - 1; c >= 0; c--) {
                    int lockR = startR + (idx / M);
                    int lockC = startC + (idx % M);
                    idx++;
                    // 범위를 벗어나거나 돌기끼리 만나면 continue
                    if (lockR < 0 || lockR >= N || lockC < 0 || lockC >= N || r < 0 || r >= M || c < 0 || c >= M) continue;
                    // 돌기끼리 만나면 종료
                    if (lock[lockR][lockC] == 1 && key[r][c] == 1) return false;
                    if (lock[lockR][lockC] == 0 && key[r][c] == 1) chk++;
                }
            }
        } else {
            for (int c = M - 1; c >= 0; c--) {
                for (int r = 0; r < M; r++) {
                    int lockR = startR + (idx / M);
                    int lockC = startC + (idx % M);
                    idx++;
                    // 범위를 벗어나면 continue
                    if (lockR < 0 || lockR >= N || lockC < 0 || lockC >= N || r < 0 || r >= M || c < 0 || c >= M) continue;
                    // 돌기끼리 만나면 종료
                    if (lock[lockR][lockC] == 1 && key[r][c] == 1) return false;
                    if (lock[lockR][lockC] == 0 && key[r][c] == 1) chk++;
                }
            }
        }
        if (chk == cnt) return true;
        else return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        M = key.length; // 열쇠 크기
        N = lock.length; // 자물쇠 크기
        cnt = 0; // 자물쇠 홈 개수
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (lock[r][c] == 0) cnt++;
            }
        }
        
        Outer: for (int lr = -M + 1; lr < N; lr++) {
            for (int lc = -M + 1; lc < N; lc++) {
                for (int d = 0; d < 4; d++) {
                    answer = rotation(lock, key, lr, lc, d); // 시계 방향 돌리기
                    if (answer) break Outer; // 자물쇠를 열면 종료
                }
            }
        }
        
        return answer;
    }
}