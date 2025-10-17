import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Virus {
        int r;
        int c;

        Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<Virus> viruses = new ArrayList<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) viruses.add(new Virus(i, j));
            }
        }

        int max = 0;

        Queue<Virus> queue;

        for (int i = 0; i < N * M; i++) {
            for (int j = i + 1; j < N * M; j++) {
                for (int k = j + 1; k < N * M; k++) {
                    int firstR = i / M;
                    int firstC = i % M;
                    int secondR = j / M;
                    int secondC = j % M;
                    int thirdR = k / M;
                    int thirdC = k % M;

                    if (map[firstR][firstC] != 0 || map[secondR][secondC] != 0 || map[thirdR][thirdC] != 0) {
                        continue;
                    }

                    int[][] newMap = new int[N][M];
                    int cnt = 0;

                    for (int r = 0; r < N; r++) {
                        newMap[r] = map[r].clone();
                    }

                    newMap[firstR][firstC] = newMap[secondR][secondC] = newMap[thirdR][thirdC] = 1;

                    queue = new LinkedList<>();

                    for (Virus v : viruses) {
                        queue.add(new Virus(v.r, v.c));
                    }

                    while (!queue.isEmpty()) {
                        Virus v = queue.poll();

                        int r = v.r;
                        int c = v.c;

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr < 0 || nr >= N || nc < 0 || nc >= M || newMap[nr][nc] != 0) {
                                continue;
                            }

                            newMap[nr][nc] = 2;
                            queue.add(new Virus(nr, nc));
                        }
                    }

                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (newMap[r][c] == 0) cnt++;
                        }
                    }

                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);
    }
}