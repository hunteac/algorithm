import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] cnt = new int[m][n]; // 경우의 수 누적합
        
        cnt[0][0] = 1; // 시작
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                
                if (i - 1 >= 0) {
                    if (cityMap[i - 1][j] == 2) { // 아래 방향만 이동 가능
                        int idx = i - 1;
                        while (idx >= 0) {
                            if (cityMap[idx][j] != 2) {
                                cnt[i][j] = (cnt[i][j] + cnt[idx][j]) % MOD;
                                break;
                            }
                            idx--;
                        }
                    } else {
                        cnt[i][j] = (cnt[i][j] + cnt[i - 1][j]) % MOD;
                    }
                }
                
                if (j - 1 >= 0) {
                    if (cityMap[i][j - 1] == 2) { // 오른쪽 방향만 이동 가능
                        int idx = j - 1;
                        while (idx >= 0) {
                            if (cityMap[i][idx] != 2) {
                                cnt[i][j] = (cnt[i][j] + cnt[i][idx]) % MOD;
                                break;
                            }
                            idx--;
                        }
                    } else {
                        cnt[i][j] = (cnt[i][j] + cnt[i][j - 1]) % MOD;    
                    }
                }
            }
        }
        
        return cnt[m - 1][n - 1];
    }
}