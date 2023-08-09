import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int len = sc.nextInt();
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		map[i][j] = sc.nextInt();
            	}
            }
            int sum = 0; // 파리퇴치수 총합을 위한 변수
            int max = -1; // 최댓값을 위한 변수
            // + 모양 파리퇴치
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		sum = map[i][j];
            		for (int k = 1; k < len; k++) {
            			if (i - k >= 0) // index를 벗어나지 않는 범위에서
            				sum += map[i - k][j]; // len - 1 길이만큼 파리퇴치
            			if (i + k < n)
            				sum += map[i + k][j];
            			if (j - k >= 0)
            				sum += map[i][j - k];
            			if (j + k < n)
            				sum += map[i][j + k];
            			if (sum > max) max = sum;
            		}
            	}
            }
            // X 모양 파리퇴치
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		sum = map[i][j];
            		for (int k = 1; k < len; k++) {
            			if (i - k >= 0 && j - k >= 0) // index를 벗어나지 않는 범위에서
            				sum += map[i - k][j - k]; // len - 1 길이만큼 파리퇴치
            			if (i - k >= 0 && j + k < n)
            				sum += map[i - k][j + k];
            			if (i + k < n && j + k < n)
            				sum += map[i + k][j + k];
            			if (i + k < n && j - k >= 0)
            				sum += map[i + k][j - k];
            			if (sum > max) max = sum;
            		}
            	}
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
        sc.close();
    }
}