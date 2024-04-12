import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long getComb(int num, int cnt) { // 조합 계산
        long n = 1;

        for (int i = 1; i <= cnt; i++) {
            n *= num;
            n /= i;
            num--;
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[20001]; // 점수 존재 여부
        int[] count = new int[20001]; // 점수 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num < 0) num = 10000 - num;
            if (!check[num]) {
                check[num] = true;
                len++;
            }
            count[num]++;
        }

        int[] nums = new int[len];
        int idx = 0;

        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                if (i > 10000) nums[idx++] = 10000 - i;
                else nums[idx++] = i;
            }
        }

        boolean[] setChk = new boolean[20001]; // 중복 계산 체크
        long cnt = 0; // 경우의 수

        for (int i = 0; i < len - 1; i++) {
            int num1 = 0;
            for (int j = i + 1; j < len; j++) {
                num1 = nums[i];
                int num2 = nums[j];

                int target = -(num1 + num2); // 0을 만드는 수

                if (num1 < 0) num1 = 10000 - num1; // 음수 -> 양수 변환
                if (num2 < 0) num2 = 10000 - num2;
                if (target < -10000 || target > 10000) continue;
                if (target < 0) target = 10000 - target; // 음수 -> 양수 변환

                if (setChk[target] || setChk[num2]) continue; // 중복 계산 continue

                if (check[target]) {
                    if (num1 != target && num2 != target) { // 경우 1
                        long num = (long) count[num1] * count[num2] * count[target];
                        cnt += num;
                    } else if (num1 == target && count[num1] > 1) { // 경우 2
                        long combCnt = getComb(count[num1], 2);
                        cnt += combCnt * count[num2];
                    } else if (num2 == target && count[num2] > 1) { // 경우 3
                        long  combCnt = getComb(count[num2], 2);
                        cnt += combCnt * count[num1];
                    }
                    setChk[target] = true;
                }
            }

            Arrays.fill(setChk, false); // 초기화
            check[num1] = false; // 계산한 값 제거
        }

        if (count[0] > 2) cnt += getComb(count[0], 3); // 0이 3개인 경우

        System.out.println(cnt);
    }
}