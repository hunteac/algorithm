import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] wires = new int[N][2]; // 전깃줄 정보
        int[] cnt = new int[N]; // 구간별 전깃줄 최대 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            wires[i][0] = start;
            wires[i][1] = end;
        }

        Arrays.sort(wires, new Comparator<int[]>() { // A 지점 기준 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 1;
        cnt[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) { // 전깃줄 추가
                if (wires[j][1] < wires[i][1]) cnt[i] = Math.max(cnt[i], cnt[j] + 1); // 최대 개수 구하기
                else cnt[i] = Math.max(cnt[i], 1);
            }
            max = Math.max(max, cnt[i]);
        }

        System.out.println(N - max); // 최소 개수 출력
    }
}
