import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int lidx = 0;
        int ridx = 0;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int tmp = Math.abs(nums[left] + nums[right]);

            if (tmp < min) {
                lidx = nums[left];
                ridx = nums[right];
                min = tmp;
            }

            int next1 = Math.abs(nums[left + 1] + nums[right]);
            int next2 = Math.abs(nums[left] + nums[right - 1]);

            if (next1 > next2) right--;
            else left++;
        }

        System.out.print(lidx + " " + ridx);
    }
}