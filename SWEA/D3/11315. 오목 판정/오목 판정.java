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
            int[] dr2 = { -1, -1, 1, 1 }; // 대각선 위치 확인을 위한 delta 배열 선언 및 초기화
            int[] dc2 = { -1, 1, -1, 1 }; // 대각선 위치 확인을 위한 delta 배열 선언 및 초기화
            int answer = 0;
            int cnt = 0;
            // 행 우선순회
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].equals("o")) {
                        cnt++;
                        for (int k = 1; k < 5; k++) {
                            if (j + k < n && board[i][j + k].equals("o")) {
                                cnt++;
                                if (cnt == 5)
                                    answer = 1;
                            } else
                                break;
                        }
                    }
                    cnt = 0;
                }
            }
            cnt = 0;
            // 열 우선순회
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (board[i][j].equals("o")) {
                        cnt++;
                        for (int k = 1; k < 5; k++) {
                            if (i + k < n && board[i + k][j].equals("o")) {
                                cnt++;
                                if (cnt == 5)
                                    answer = 1;
                            } else
                                break;
                        }
                    }
                    cnt = 0;
                }
            }
            cnt = 0;
            // 대각선 왼쪽 위 오른쪽 아래 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].equals("o")) {
                        cnt++;
                        for (int k = 1; k < 5; k++) {
                            if (i - k >= 0 && j - k >= 0) {
                                if (board[i - k][j - k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else 
                                	break;
                            }
                            if (i + k < n && j + k < n) {
                                if (board[i + k][j + k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else 
                                	break;
                            }
                        }
                    }
                    cnt = 0;
                }
            }
            cnt = 0;
            // 대각선 오른쪽 위 왼쪽 아래 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].equals("o")) {
                        cnt++;
                        for (int k = 1; k < 5; k++) {
                            if (i - k >= 0 && j + k < n) {
                                if (board[i - k][j + k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else 
                                	break;
                            }
                            if (j - k >= 0 && i + k < n) {
                                if (board[i + k][j - k].equals("o")) {
                                	cnt++;
                                	if (cnt == 5)
                                		answer = 1;
                                } else 
                                	break;
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