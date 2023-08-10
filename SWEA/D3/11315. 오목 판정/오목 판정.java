import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String[][] board = new String[n][n];

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = s.charAt(j) + "";
                }
            }
            int answer = 0;
            int cnt = 0;
            // 행 우선순회
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].equals("o")) {
                        cnt++;
                        // 행 체크
                        for (int k = 1; k < 5; k++) {
                            if (j + k < n && board[i][j + k].equals("o")) {
                                cnt++;
                                if (cnt == 5)
                                    answer = 1;
                            } else {
                            	cnt = 0;
                            	break;
                            }
                        }
                        // 열 체크
                        cnt = 1;
                        for (int k = 1; k < 5; k++) {
                            if (i + k < n && board[i + k][j].equals("o")) {
                                cnt++;
                                if (cnt == 5)
                                    answer = 1;
                            } else {
                            	cnt = 0;
                            	break;
                            }
                        }
                        // 왼쪽 위, 오른쪽 아래 대각선 확인
                        cnt = 1;
                        for (int k = 1; k < 5; k++) {
                            if (i - k >= 0 && j - k >= 0) {
                                if (board[i - k][j - k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else {
                                	cnt = 0;
                                	break;
                                }
                            }
                            if (i + k < n && j + k < n) {
                                if (board[i + k][j + k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else {
                                	cnt = 0;
                                	break;
                                }
                            }
                        }
                        // 오른쪽 위, 왼쪽 아래 대각선 확인
                        cnt = 1;
                        for (int k = 1; k < 5; k++) {
                            if (i - k >= 0 && j + k < n) {
                                if (board[i - k][j + k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else {
                                	cnt = 0;
                                	break;
                                }
                            }
                            if (j - k >= 0 && i + k < n) {
                                if (board[i + k][j - k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else {
                                	cnt = 0;
                                	break;
                                }
                            }
                        }
                    }
                    cnt = 0;
                }
            }
            if (answer == 1)
                System.out.println("#" + test_case + " " + "YES");
            else
                System.out.println("#" + test_case + " " + "NO");
        }
        sc.close();
    }
}