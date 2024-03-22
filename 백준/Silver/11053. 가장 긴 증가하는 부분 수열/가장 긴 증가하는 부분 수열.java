import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int max = 1; // 최대 길이
        dp[0] = 1; // 초기 수열의 길이

        for (int i = 1; i < N; i++) {
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) { // 부분 최대 길이 구하기
                if (nums[i] > nums[j]) cnt = Math.max(cnt, dp[j] + 1);
            }

            dp[i] = cnt;

            max = Math.max(max, dp[i]); // 최댓값 갱신
        }

        System.out.println(max);
    }
}
