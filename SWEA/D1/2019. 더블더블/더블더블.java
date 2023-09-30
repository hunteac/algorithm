import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 1;

        for (int i = 0; i <= n; i++) {
            System.out.print(num + " ");
            num *= 2;
        }
    }
}