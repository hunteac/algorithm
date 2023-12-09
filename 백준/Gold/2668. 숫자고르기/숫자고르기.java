import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    static HashSet<Integer> set1; // 집합1
    static HashSet<Integer> set2; // 집합2
    static boolean[] visited; // 방문 체크
    static int[] nums;
    static int N;

    static void comb(int idx) {
        if (visited[idx]) return;
        visited[idx] = true;

        set1.add(idx);
        set2.add(nums[idx]);

        comb(nums[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(br.readLine());

        ArrayList<Integer> set = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            set1 = new HashSet<>(); // 첫번째 집합
            set2 = new HashSet<>(); // 두번째 집합

            comb(i); // 집합 구하기

            boolean chk = true;

            for (Integer n : set1) {
                if (!set2.contains(n)) { // 집합이 동일하지 않으면
                    chk = false; // false
                    break;
                }
            }

            if (chk) { // 집합이 동일하면 출력 리스트에 담기
                for (Integer n : set1) if (!set.contains(n)) set.add(n);
            } else { // 동일하지 않으면 방문처리 초기화
                for (Integer n : set2) visited[n] = false;
            }
        }

        Collections.sort(set); // 오름차순 정렬

        System.out.println(set.size()); // 정수 개수 출력
        for (Integer n : set) System.out.println(n); // 집합 정수 출력
    }
}