import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] count = new int[8001];
        double sum = 0;
        int max = -4001;
        int min = 4001;
        int mini = 4001;
        int scdi = 4001;
        int tmpi = 0;
        int cnt = 1;
        int tmpcnt = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i]; // 평균을 구하기 위한 총합
            max = Math.max(max, nums[i]); // 최댓값 구하기
            min = Math.min(min, nums[i]); // 최솟값 구하기
            if (nums[i] < 0) count[4000 - nums[i]]++; // 음수인 경우는 인덱스를 벗어나기 때문에 4001부터 계산
            else if (nums[i] >= 0) count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= cnt) {
                cnt = count[i]; // 최빈값 구하기
            }
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == cnt) {
                tmpi = i;
                tmpcnt++;
                if (tmpi > 4000) tmpi = (-(tmpi - 4000));
                if (tmpi < mini) mini = tmpi; // 최빈값 중 최솟값 구하기
            }
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == cnt) {
                tmpi = i;
                if (tmpi > 4000) tmpi = (-(tmpi - 4000));
                if (tmpi < scdi) {
                    if (tmpi > mini) scdi = tmpi; // 최빈값 중 두번째로 작은값 구하기
                }
            }
        }
        Arrays.sort(nums);
        System.out.println(Math.round(sum / N));
        System.out.println(nums[N / 2]);
        if (tmpcnt == 1) System.out.println(mini);
        else System.out.println(scdi); // 최빈값이 여러 개 있을 경우 그 중 두 번째로 작은 값 출력
        System.out.println(max - min);
    }
}