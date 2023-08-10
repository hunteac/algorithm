import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            // 8방향 순회를 위한 1차원 배열 두개 생성
            int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
            int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
            boolean flag = false;
            OuterLoop: for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		if (board[i][j] == 'o') {
            			for (int k = 0; k < 8; k++) {
            				int cnt = 1;
            				int ti = i;
            				int tj = j;
            				while (true) {
            					int tc = tj + dc[k]; 
            					int tr = ti + dr[k];
            					
            					if (tc >= 0 && tr >= 0 && tc < n && tr < n && board[tr][tc] == 'o') {
            						ti = tr;
            						tj = tc;
            						cnt++;
            					} else
            						break;
            					if (cnt == 5) {
            						flag = true;
            						break OuterLoop;
            					}
            				}
            			}
            		}
            	}
            }
            if (flag) System.out.printf("#%d %s\n", test_case, "YES");
            else System.out.printf("#%d %s\n", test_case, "NO");
        }
        sc.close();
    }
}