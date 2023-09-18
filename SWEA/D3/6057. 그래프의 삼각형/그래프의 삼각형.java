import java.util.Scanner;

public class Solution {
    public static int N; // 정점 개수
    public static int M; // 간선 개수
    public static int answer; // 삼각형 개수
    public static int[][] adjArr; // 인접 행렬

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            adjArr = new int[N + 1][N + 1];
            answer = 0;
            for (int i = 0; i < M; i++) {
                int A = sc.nextInt(); // 시작 정점
                int B = sc.nextInt(); // 끝 정점
                adjArr[A][B] = 1;
                adjArr[B][A] = 1;
            }
            getTriangle(0, 0, 0);
            System.out.println("#" + tc + " " + answer);
        }
    }
    // DFS로 삼각형 개수 구하는 메소드
    public static void getTriangle(int startNode, int node, int len) {
        if (len == 3) {
            if (adjArr[node][startNode] == 1) {
                answer++;
                return;
            } else return;
        }
        for (int i = node + 1; i < N + 1; i++) {
            if (startNode == 0) {
                getTriangle(i, i, len + 1);
            } else  if (adjArr[i][node] == 1) {
                getTriangle(startNode, i, len + 1);
            }
        }
    }
}