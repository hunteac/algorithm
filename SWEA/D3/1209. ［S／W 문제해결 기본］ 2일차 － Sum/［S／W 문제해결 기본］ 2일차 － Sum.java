import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int[][] matrix = new int[100][100];
            for (int i = 0; i < 100; i++) {
            	for (int j = 0; j < 100; j++) {
            		matrix[i][j] = sc.nextInt();
            	}
            }
            int sum1 = 0;
            int sum2 = 0;
            int max = 0;
            // 행 최댓값 구하기
            for (int i = 0; i < 100; i++) { 
            	for (int j = 0; j < 100; j++) {
            		sum1 += matrix[i][j];
            	}
            	max = Math.max(max, sum1);
            	sum1 = 0;
            }
            // 열 최댓값 구하기
            for (int j = 0; j < 100; j++) { 
            	for (int i = 0; i < 100; i++) {
            		sum1 += matrix[i][j];
            	}
            	max = Math.max(max, sum1);
            	sum1 = 0;
            }
            // 대각선 최댓값 구하기
            for (int i = 0; i < 100; i++) { 
            	sum1 += matrix[i][i]; // 좌 -> 우 방향
            	sum2 += matrix[i][99 - i]; // 우 -> 좌 방향
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
            System.out.printf("#%d %d\n", n, max);
        }
        sc.close();
    }
}