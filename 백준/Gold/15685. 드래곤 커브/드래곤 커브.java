import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x;
        int y;
        int d;
        int g;

        Pos (int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Pos> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            list.add(new Pos(x, y, d, g));
        }

        boolean[][] map = new boolean[101][101];
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        for (int i = 0; i < N; i++) {
            Pos p = list.get(i);

            ArrayList<Integer> dir = new ArrayList<>(); // 진행 방향
            dir.add(p.d);
            int cx = p.x + dx[dir.get(0)]; // 0세대
            int cy = p.y + dy[dir.get(0)];
            map[p.x][p.y] = map[cx][cy] = true;

            for (int j = 1; j <= p.g; j++) {
                int len = dir.size();
                for (int k = len - 1; k >= 0; k--) {
                    int next = (dir.get(k) + 1) % 4; // 90도 회전
                    dir.add(next);

                    cx += dx[next];
                    cy += dy[next];

                    map[cx][cy] = true;
                }
            }
        }

        int cnt = 0; // 사각형 개수

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                if (x == 100 || y == 100) continue;

                // 모든 꼭짓점이 드래곤 커브
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1]) cnt++;
            }
        }

        System.out.println(cnt);
    }
}