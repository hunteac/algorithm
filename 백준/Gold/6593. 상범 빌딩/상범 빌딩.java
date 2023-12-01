import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int l;
        int r;
        int c;
        Pos (int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static Queue<Pos> queue;
    static boolean[][][] visited;
    static char[][][] building;
    static int[] dl = { -1, 1, 0, 0, 0, 0 };
    static int[] dr = { 0, 0, -1, 0, 1, 0 };
    static int[] dc = { 0, 0, 0, 1, 0, -1 };
    static int L;
    static int R;
    static int C;
    static int time;
    static boolean chk;

    static void bfs(int l, int r, int c) {
        queue.add(new Pos(l, r, c));
        visited[l][r][c] = true;

        Outer: while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pos p = queue.poll();

                l = p.l;
                r = p.r;
                c = p.c;

                if (building[l][r][c] == 'E') {
                    chk = true;
                    break Outer;
                }

                for (int d = 0; d < 6; d++) {
                    int nl = l + dl[d];
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || visited[nl][nr][nc] ||
                    building[nl][nr][nc] == '#') continue;

                    visited[nl][nr][nc] = true;

                    queue.add(new Pos(nl, nr, nc));
                }
            }

            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            queue = new LinkedList<>();
            visited = new boolean[L][R][C];
            building = new char[L][R][C];

            chk = false;
            time = 0;
            int l = 0;
            int r = 0;
            int c = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S') {
                            l = i;
                            r = j;
                            c = k;
                        }
                    }

                }
                String tmp = br.readLine();
            }

            bfs(l, r, c);

            if (chk) sb.append("Escaped in " + time + " minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");
        }

        System.out.println(sb);
    }
}