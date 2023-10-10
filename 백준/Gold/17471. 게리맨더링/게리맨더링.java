import java.util.*;

public class Main {
    static List<Integer>[] edges; // 연결 리스트
    static boolean[] sel; // 부분 집합
    static boolean[] visited; // 방문 처리
    static int[] nums; // 구역별 인구수
    static boolean chk; // 구역 생성 가능 체크
    static int N; // 구역 개수
    static int sum; // 인구수 총합
    static int min; // 인구 차이 최솟값
    static int cnt; // 한 구역 인구수
    static int len;

    // 연결을 끊을 부분 집합 구하기
    static void powerSet(int idx) {
        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            cnt = 0;
            for (int i = 1; i < sel.length; i++) {
                if (sel[i]) cnt++;
            }
            if (cnt == N || cnt == 0) return;

            int tstart = 0;
            int tlen = 0;
            int fstart = 0;
            int flen = 0;
            for (int i = 1; i < sel.length; i++) {
                if (sel[i] && tstart == 0) tstart = i;
                if (sel[i]) tlen++;
                if (!sel[i] && fstart == 0) fstart = i;
                if (!sel[i]) flen++;
            }

            cnt = 0;
            chk = true;

            visited = new boolean[N + 1];
            len = 0;
            DFS1(tstart);
            if (len != tlen) chk = false;
            visited = new boolean[N + 1];
            len = 0;
            DFS2(fstart);
            if (len != flen) chk = false;

            if (chk) {
                for (int i = 1; i < sel.length; i++) {
                    if (sel[i]) cnt += nums[i];
                }
            } else {
                return;
            }

            min = Math.min(min, Math.abs(cnt * 2 - sum));

            return;
        }

        sel[idx] = true;
        powerSet(idx + 1);
        sel[idx] = false;
        powerSet(idx + 1);
    }

    static void DFS1(int idx) {
        for (int i = 1; i < sel.length; i++) {
            if (visited[i] || !sel[i] || !edges[idx].contains(i)) continue;
            visited[i] = true;
            len++;
            DFS1(i);
        }
    }

    static void DFS2(int idx) {
        for (int i = 1; i < sel.length; i++) {
            if (visited[i] || sel[i] || !edges[idx].contains(i)) continue;
            visited[i] = true;
            len++;
            DFS2(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        edges = new LinkedList[N + 1];
        sel = new boolean[N + 1];
        nums = new int[N + 1];

        min = Integer.MAX_VALUE;
        sum = 0;
        cnt = 0;

        for (int i = 1; i <= N; i++) {
            edges[i] = new LinkedList<>();
        }

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int A = sc.nextInt();
                edges[i].add(A);
            }
            edges[i].add(i);
        }

        powerSet(1);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}