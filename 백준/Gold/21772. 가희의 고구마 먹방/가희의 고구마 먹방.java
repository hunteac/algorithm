import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r; // 현재 행
        int c; // 현재 열
        int cnt; // 먹은 고구마 개수
        LinkedList<Integer[]> ate; // 먹은 고구마들의 위치
        Pos (int r, int c, int cnt, LinkedList<Integer[]> ate) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.ate = ate;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 세로 크기
        int C = Integer.parseInt(st.nextToken()); // 가로 크기
        int T = Integer.parseInt(st.nextToken()); // 이동 시간

        Queue<Pos> queue = new LinkedList<>();
        char[][] room = new char[R][C]; // 방
        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                room[i][j] = str.charAt(j);
                if (room[i][j] == 'G') queue.add(new Pos(i, j, 0, new LinkedList<>())); // 가희 출발 위치
            }
        }

        int max = 0; // 최대 고구마 개수
        int time = -1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pos p = queue.poll(); // 현재 위치

                max = Math.max(max, p.cnt); // 최대 개수 갱신
                LinkedList<Integer[]> ate = new LinkedList<>(p.ate); // 현재 경로에서 먹은 고구마 위치를 담는 리스트

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d]; // 다음 행
                    int nc = p.c + dc[d]; // 다음 열
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || room[nr][nc] == '#') continue;

                    boolean chk = true; // 다음 위치의 고구마를 먹었는지 확인
                    for (int j = 0; j < ate.size(); j++) if (ate.get(j)[0] == nr && ate.get(j)[1] == nc) chk = false;

                    if (chk && room[nr][nc] == 'S') { // 아직 먹지 않은 고구마가 있는 경우
                        ate.add(new Integer[] {nr, nc}); // 먹은 고구마 위치 담기
                        queue.add(new Pos(nr, nc, p.cnt + 1, new LinkedList<>(ate))); // 고구마 먹기
                        ate.remove(ate.size() - 1);
                    } else queue.add(new Pos(nr, nc, p.cnt, ate)); // 빈 공간
                }
            }

            time++; // 시간 증가
            if (T == time) break; // 종료
        }

        System.out.println(max);
    }
}