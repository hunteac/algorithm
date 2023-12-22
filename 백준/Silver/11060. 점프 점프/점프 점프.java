import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 과일의 개수
        st = new StringTokenizer(br.readLine());

        int[] maze = new int[N];

        for (int i = 0; i < N; i++) maze[i] = Integer.parseInt(st.nextToken());

        int min = 0; // 최소 횟수
        int curr = 0; // 현재 위치
        boolean chk = false; // 가능 여부

        Outer: while (curr < N) {
            int len = maze[curr]; // 뛸 수 있는 거리
            if (N == 1) { // 가능
                chk = true;
                break;
            }
            if (len == 0) break; // 불가능

            int tmp = curr;
            int nIdx = 0; // 가장 멀리뛸 수 있는 다음 위치
            min++;

            for (int idx = tmp + 1; idx <= tmp + len; idx++) {
                if (idx >= N - 1) { // 도착
                    chk = true;
                    break Outer;
                }
                if (idx + maze[idx] > nIdx) { // 최대 거리 갱신
                    nIdx = idx + maze[idx];
                    curr = idx;
                }
            }
        }

        if (chk) System.out.println(min);
        else System.out.println(-1);
    }
}
