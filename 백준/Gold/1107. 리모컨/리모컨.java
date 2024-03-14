import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] nums; // 누를 수 있는 번호
    static int[] comb; // 조합 배열
    static String N; // 목표 채널
    static int M;
    static int min; // 최소 횟수

    // 중복 조합 알고리즘
    static void combination(int idx, int len) {
        int cnt = idx; // 누른 횟수

        String curr = "";

        for (int i = 0; i < idx; i++) curr += String.valueOf(comb[i]); // 현재 채널

        if (!curr.equals("")) {
            cnt -= cnt - String.valueOf(Integer.parseInt(curr)).length(); // 앞자리 0체크

            // 현재 채널과 목표 채널의 차이를 비교하여 횟수 추가
            int dif = Math.abs(Integer.parseInt(N) - Integer.parseInt(curr));

            min = Math.min(min, cnt + dif); // 최솟값 갱신
        }

        if (idx == comb.length) return;

        for (int i = 0; i < len; i++) {
            comb[idx] = nums[i];
            combination(idx + 1, len);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        M = Integer.parseInt(br.readLine());

        if (N.length() < 6) comb = new int[N.length() + 1];
        else comb = new int[N.length()];

        HashSet<Integer> broken = new HashSet<>();

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) broken.add(Integer.parseInt(st.nextToken()));
        }

        nums = new int[10 - broken.size()];

        int idx = 0;

        for (int i = 0; i <= 9; i++) {
            if (!broken.contains(i)) {
                nums[idx++] = i;
            }
        }

        min = Integer.MAX_VALUE;

        combination(0, nums.length);

        // 초기 위치가 더 가까우면 갱신
        min = Math.min(min, Math.abs(Integer.parseInt(N) - 100));

        System.out.println(min);
    }
}