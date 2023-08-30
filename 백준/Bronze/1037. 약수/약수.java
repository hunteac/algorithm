import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = 0;
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        if (nums.length % 2 == 0) A = nums[0] * nums[N - 1]; // 진짜 약수 개수 짝수
        else A = nums[N / 2] * nums[N / 2]; // 진짜 약수 개수 홀수
        System.out.println(A);
    }
}