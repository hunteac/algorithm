import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) { // 두 수의 합 구하기
            for (int j = i; j < N; j++) {
                list.add(nums[i] + nums[j]);
            }
        }

        Arrays.sort(nums); // 오름차순 정렬
        Collections.sort(list);

        int max = 0; // 세 수의 합 최댓값

        Outer: for (int i = N - 1; i >= 0; i--) {
            max = nums[i];

            for (int j = 0; j < i; j++) {
                int sum = nums[j];

                int left = 0;
                int right = list.size();

                // 이분탐색
                while (left <= right) {
                    int mid = (left + right) / 2;

                    int comp = sum + list.get(mid);

                    if (comp < max) {
                        left = mid + 1;
                    } else if (comp > max) {
                        right = mid - 1;
                    } else {
                        break Outer;
                    }
                }
            }
        }

        System.out.println(max);
    }
}