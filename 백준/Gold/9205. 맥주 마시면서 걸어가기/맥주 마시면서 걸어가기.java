import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer[]> store; // 편의점 위치
    static boolean[] visited; // 방문 체크
    static int N, startX, startY, endX, endY;
    static boolean chk; // 가능 여부

    static void walk(int currX, int currY) {
        if (chk) return;
        if (Math.abs(endX - currX) + Math.abs(endY - currY) <= 1000) { // 페스티벌 도착
            chk = true;
            return;
        }

        for (int idx = 0; idx < N; idx++) {
            if (visited[idx]) continue; // 이미 방문한 편의점은 continue
            int nextX = store.get(idx)[0];
            int nextY = store.get(idx)[1];
            if (Math.abs(currX - nextX) + Math.abs(currY - nextY) > 1000) continue; // 방문 불가

            visited[idx] = true; // 방문 처리
            walk(nextX, nextY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken()); // 시작 위치
            startY = Integer.parseInt(st.nextToken());

            store = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                store.add(new Integer[]{x, y});
            }

            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken()); // 도착 위치
            endY = Integer.parseInt(st.nextToken());

            visited = new boolean[N];
            chk = false;

            walk(startX, startY);

            if (chk) sb.append("happy").append("\n"); // 도착 가능
            else sb.append("sad").append("\n"); // 도착 불가능
        }

        System.out.println(sb);
    }
}