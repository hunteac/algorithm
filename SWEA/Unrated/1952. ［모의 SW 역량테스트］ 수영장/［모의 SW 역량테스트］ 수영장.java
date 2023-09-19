import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int[] price = new int[4]; // 요금
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] days = new int[13];
            for (int i = 1; i <= 12; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[13];
            for (int i = 1; i <= 12; i++) {
                sum[i] = sum[i-1] + Math.min(days[i] * price[0], price[1]);
                if (i >= 3) sum[i] = Math.min(sum[i], sum[i-3] + price[2]);
            }
            
            int answer = Math.min(sum[12], price[3]);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}