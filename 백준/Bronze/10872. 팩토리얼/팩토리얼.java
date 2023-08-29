import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = 1;
        for (int i = N; i >= 1; i--) {
            F *= i; // 팩토리얼
        }
        System.out.println(F);
    }
}