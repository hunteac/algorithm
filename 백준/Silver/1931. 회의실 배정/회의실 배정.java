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

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의가 끝나는 시간 기준으로 오름차순 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int end = time[0][1]; // 첫 회의가 끝나는 시간
        int cnt = 1; // 회의 개수

        for (int i = 1; i < N; i++) {
            if (time[i][0] < end) continue; // 끝나기 전에 시작하면 continue

            end = time[i][1]; // 끝나는 시간 갱신
            cnt++; // 개수 증가
        }

        System.out.println(cnt);
    }
}