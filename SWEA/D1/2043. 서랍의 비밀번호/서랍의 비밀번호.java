import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 1;

        while (P > K) {
            K++;
            cnt++;
        }

        System.out.println(cnt);
    }
}