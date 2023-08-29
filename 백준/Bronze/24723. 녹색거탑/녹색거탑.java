import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 상, 하의 N벌
        int top = 1; // 녹색거탑 꼭대기 층
        for (int i = 0; i < N; i++) {
            top *= 2; // 한 층 내려갈 때 한 블록에서 가능한 경우의 수 : 2가지
        }
        System.out.println(top);
    }
}