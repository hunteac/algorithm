import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int D = nums[n - 1]; // 가장 큰 정수
        int left = 0; // 나머지

        while (true) {
            if (D == 0) continue;
            boolean chk = true;

            if (nums[0] >= 0) left = nums[0] % D; // 양수 나머지 구하기
            else left = (Math.abs(nums[0] / D - 1) * D) + nums[0]; // 음수 나머지 구하기

            for (int i = 1; i < n; i++) {
                if (nums[i] >= 0) {
                    if (left != nums[i] % D) {
                        chk = false;
                        break;
                    }
                } else {
                    int temp = (Math.abs(nums[i] / D - 1) * D) + nums[i];
                    if (left != temp) {
                        chk = false;
                        break;
                    }
                }
            }

            if (chk) break;
            else D--;
        }

        System.out.println(D);
    }
}