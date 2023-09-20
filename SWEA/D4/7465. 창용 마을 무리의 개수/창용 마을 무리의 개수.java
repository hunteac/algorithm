import java.util.Scanner;

public class Solution {
    static int[] p; // 해당 원소가 속한 집합의 대표

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 사람 수 (정점)
            int M = sc.nextInt(); // 관계 수 (간선)
            p = new int[N + 1];
            // mindset
            for (int i = 0; i < N + 1; i++) {
                p[i] = i;
            }

            int group = N;
            for (int i = 0; i < M; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                if (union(A, B)) group--;
            }

            System.out.println("#" + tc + " " + group);
        }
    }
    static int findset(int x) {
        if (x == p[x]) return x;
        return p[x] = findset(p[x]);
    }

    static boolean union(int x, int y) {
        int A = findset(x);
        int B = findset(y);
        if (A == B) return false;
        p[A] = B;
        return true;
    }
}