import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // 농장 크기 입력
        	int N = Integer.parseInt(br.readLine());
        	// N * N 크기의 농장 생성
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
            	String s = br.readLine();
            	for (int j = 0; j < N; j++) {
            		farm[i][j] = s.charAt(j) - 48;
            	}
            }
            // 수익 총합을 위한 변수
            int sum = 0;
            int idx = N - 1;
            // 정사각형 마름모 모양의 위 꼭지점부터 농작물을 수확하는 이중 반복문
            for (int i = 0; i < N; i++) {
            	if (i < (N + 1) / 2) {
            		for (int j = N / 2 - i; j <= N / 2 + i; j++) { 
            			sum += farm[i][j];
            		}
            	} else {
            		for (int j = i - (N / 2); j < idx; j++) {
            			sum += farm[i][j];
            		}
            		idx--;
            	}
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}