import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] nums = new int[N]; // 수 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int cnt = 0; // 좋은 수 개수

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int num = nums[i] + nums[j]; // 두 수 합치기

                // 다른 수 두 개의 합으로 나타낼 수 없으면 continue
                if (!map.containsKey(num)) continue;
                if ((num == nums[i] && map.get(num) <= 1) || (num == nums[j] && map.get(num) <= 1)) continue;
                if (num == nums[i] && num == nums[j] && map.get(num) < 3) continue;

                cnt += map.get(num); // 개수 증가
                map.remove(num); // 제외
            }
        }

        System.out.println(cnt);
    }
}