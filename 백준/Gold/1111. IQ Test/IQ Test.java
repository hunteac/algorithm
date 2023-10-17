import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) System.out.println("A"); // 1개는 다음 수가 여러 개 존재할 수 있다.
        else if (N == 2) { // 2개의 경우 두 수가 같지 않으면 다음 수가 여러 개 존재할 수 있다.
            if (nums[0] == nums[1]) System.out.println(nums[0]);
            else System.out.println("A");
        } else { // 3개 이상인 경우
            boolean chk = true; // 다음 수를 구할 수 있는지 확인
            int a = 0;
            int b = 0;
            if (nums[1] - nums[0] == 0 && nums[2] - nums[1] == 0) { // a == 1 인 경우
                a = 1;
            } else if (nums[1] - nums[0] == 0) { // nums[1] - nums[0] == 0 인 경우는 다음 수를 구할 수 없다.
                System.out.println("B");
                return;
            } else { // a, b 구하기
                a = (nums[2] - nums[1]) / (nums[1] - nums[0]);
                b = nums[nums.length - 1] - nums[nums.length - 2] * a;
            }

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] * a + b != nums[i + 1]) chk = false; // 다음 수를 구할 수 없으면 false
            }

            if (chk) System.out.println(nums[nums.length - 1] * a + b);
            else System.out.println("B");
        }
    }
}