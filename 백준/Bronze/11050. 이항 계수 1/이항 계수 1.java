import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int tmpN = 1;
        int tmpK = 1;
        for (int i = 1; i <= K; i++) { // 조합 계산
            tmpN *= N--;
            tmpK *= i;
        }
        System.out.println(tmpN / tmpK);
    }
}