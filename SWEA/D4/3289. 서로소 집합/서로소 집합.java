import java.util.Scanner;

public class Solution {
    static int[] p; // 해당 원소가 속한 집합의 대표

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 집합 수
            int M = sc.nextInt(); // 연산 수
            p = new int[N + 1];
            // mindset
            for (int i = 0; i < N + 1; i++) {
                p[i] = i;
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < M; i++) {
                int chk = sc.nextInt();
                int A = sc.nextInt();
                int B = sc.nextInt();
                if (chk == 0) union(A, B); // 0은 합집합 수행
                else { // 1은 같은 집합 여부 체크
                    if (findset(A) != findset(B)) System.out.print(0);
                    else System.out.print(1);
                }
            }
            System.out.println();
        }
    }
    
    static int findset(int x) {
        if (x == p[x]) return x;
        return p[x] = findset(p[x]);
    }

    static void union(int x, int y) {
        int A = findset(x);
        int B = findset(y);
        if (A != B) p[A] = B;
    }
}