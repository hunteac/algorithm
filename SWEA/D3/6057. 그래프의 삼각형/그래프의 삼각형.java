import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 정점 개수
            int M = sc.nextInt(); // 간선 개수
            int answer = 0; // 삼각형 개수
            int[][] adjArr = new int[N + 1][N + 1]; // 인접 행렬
            for (int i = 0; i < M; i++) {
                int A = sc.nextInt(); // 시작 정점
                int B = sc.nextInt(); // 끝 정점
                adjArr[A][B] = 1;
            }
            for (int i = 1; i < N - 1; i++) { // 조합 구하는 방식으로 삼각형 개수 구하기
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N + 1; k++) {
                        if (adjArr[i][j] == 1 && adjArr[i][k] == 1 && adjArr[j][k] == 1) {
                            answer++;
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}