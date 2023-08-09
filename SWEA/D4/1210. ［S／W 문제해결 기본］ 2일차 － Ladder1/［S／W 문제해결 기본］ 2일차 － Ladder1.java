import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int[][] ld = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ld[i][j] = sc.nextInt();
                }
            }
            int st = 0; // 시작지점 변수 설정
            int col = 0; // 좌우 이동을 위한 변수 설정
            OuterLoop: for (int j = 0; j < 100; j++) {
                st = j; 
                col = j;
                for (int i = 0; i < 100; i++) {
                	if (ld[i][col] == 2) { // 2를 찾았을 때 이중 for문 벗어나기
                    	break OuterLoop;
                    }
                	if (ld[i][col] == 1) { 
                        if (col + 1 < 100 && ld[i][col + 1] == 1) { // 우 방향 이동 통로를 발견했을 때
                        	while (col + 1 < 100 && ld[i][col + 1] == 1) { // 우 방향 이동
                        		col++;
                        	}
                        } else if (col - 1 >= 0 && ld[i][col - 1] == 1) { // 좌 방향 이동 통로를 발견했을 때
                        	while (col - 1 >= 0 && ld[i][col - 1] == 1) { // 좌 방향 이동
                        		col--;
                        	}
                        }
                    } else { // 1이 아닌 경우 행 이동
                    	break;
                    }
                }
            }
            System.out.printf("#%d %d\n", n, st);
        }
        sc.close();
    }
}