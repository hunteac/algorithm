import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int[] freq = new int[8001]; //최빈값 배열
        int sum = 0;
        int max_freq = 0;
        for(int i = 0; i < N; i++) {
            sum+= nums[i];
            freq[nums[i]+4000]++;
            if(freq[nums[i]+4000] > max_freq) {
                max_freq = freq[nums[i]+4000];
            }
        }
        System.out.println(Math.round((sum / (double)N))); // 산술평균
        System.out.println(nums[N/2]); // 중앙값
        int cnt = 0;
        int idx = 0;
        for(int i = 0; i < 8001; i++) {
            if(freq[i] == max_freq) {
                cnt++;
                idx = i;
            }
            if(cnt == 2) {
                System.out.println(idx - 4000); // 최빈값이 여러개인 경우
                break;
            }
        }
        if(cnt == 1) {
            System.out.println(idx - 4000); // 최빈값이 하나인 경우
        }
        System.out.println(nums[N-1] - nums[0]); // 범위
    }
}