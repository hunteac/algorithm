import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 상, 하의 N벌
        System.out.println(N * (N - 1)); // 상의 N벌, 하의(N - 1)벌
    }
}