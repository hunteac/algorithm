import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        ArrayList<Integer[]> virusList = new ArrayList<>();
        ArrayList<Integer[]> emptyList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptyList.add(new Integer[]{i, j});
                } else if (map[i][j] == 2) {
                    virusList.add(new Integer[]{i, j});
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int max = 0;

        for (int i = 0; i < emptyList.size() - 2; i++) {
            for (int j = i + 1; j < emptyList.size() - 1; j++) {
                for (int k = j + 1; k < emptyList.size(); k++) {
                    // 새로운 지도 만들기
                    int[][] newMap = new int[N][M];

                    for (int idx = 0; idx < N; idx++) {
                        newMap[idx] = map[idx].clone();
                    }

                    // 벽 세우기
                    newMap[emptyList.get(i)[0]][emptyList.get(i)[1]] = 1;
                    newMap[emptyList.get(j)[0]][emptyList.get(j)[1]] = 1;
                    newMap[emptyList.get(k)[0]][emptyList.get(k)[1]] = 1;

                    // 바이러스 퍼트리기
                    Queue<Integer[]> queue = new LinkedList<>();

                    for (Integer[] virus : virusList) {
                        queue.add(new Integer[]{virus[0], virus[1]});
                    }

                    while (!queue.isEmpty()) {
                        Integer[] virus = queue.poll();
                        int r = virus[0];
                        int c = virus[1];

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                                if (newMap[nr][nc] == 0) {
                                    newMap[nr][nc] = 2;
                                    queue.add(new Integer[]{nr, nc});
                                }
                            }
                        }
                    }

                    // 안전영역 계산
                    int tmpMax = 0;
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (newMap[r][c] == 0) {
                                tmpMax++;
                            }
                        }
                    }

                    max = Math.max(max, tmpMax);
                }
            }
        }

        System.out.println(max);
    }
}