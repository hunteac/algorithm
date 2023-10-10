import java.io.*;
import java.util.*;

public class Main {
    static class Pos { // 현재 미로의 좌표를 가지는 객체
        int curR; // 현재 행
        int curC; // 현재 열
        int curZ; // 현재 칸
        int dist; // 현재 거리

        Pos(int curR, int curC, int curZ, int dist) {
            this.curR = curR;
            this.curC = curC;
            this.curZ = curZ;
            this.dist = dist;
        }
    }

    static Queue<Pos> queue; // 현재 좌표 위치를 담는 큐
    static boolean[][][] visited; // 방문 처리
    static boolean[][][] maze; // 미로
    static boolean[][][] tmpMaze; // 조합 미로
    static boolean[] pVisited; // 순열 방문 처리
    static int[] dr = { 0, -1, 0, 1, 0 }; // 행 좌표
    static int[] dc = { 0, 0, 1, 0, -1 }; // 열 좌표
    static int[] stR = { 0, 0, 4, 4 }; // 미로 출발 행 좌표
    static int[] stC = { 0, 4, 0, 4 }; // 미로 출발 열 좌표
    static int[] p; // 순열 배열
    static int goalR; // 목표 행 좌표
    static int goalC; // 목표 열 좌표
    static int min; // 최소 이동 거리

    static void perm(int idx) {
        // 순열 완성
        if (idx == 5) {
            for (int t = 0; t < 4; t++) {
                Turn(t, 0);
                for (int t1 = 0; t1 < 4; t1++) {
                    Turn(t1, 1);
                    for (int t2 = 0; t2 < 4; t2++) {
                        Turn(t2, 2);
                        for (int t3 = 0; t3 < 4; t3++) {
                            Turn(t3,3);
                            for (int t4 = 0; t4 < 4; t4++) {
                                Turn(t4, 4);
                                for (int i = 0; i < 4; i++) {
                                    // 출발할 수 없거나 도착할 수 없으면 continue
                                    if (!tmpMaze[4][Math.abs(stR[i] - 4)][Math.abs(stC[i] - 4)] || !tmpMaze[0][stR[i]][stC[i]]) continue;
                                    visited = new boolean[5][5][5];
                                    goalR = Math.abs(stR[i] - 4);
                                    goalC = Math.abs(stC[i] - 4);
                                    BFS(stR[i], stC[i]);
                                    if (min == 12) return;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (pVisited[i]) continue; // 이미 선택한 원소는 continue
            pVisited[i] = true; // 원소 선택
            p[idx] = i;
            perm(idx + 1);
            pVisited[i] = false; // 원소 선택 X
        }
    }

    // 미로판 돌리기
    static void Turn(int t, int pick) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (t == 0) tmpMaze[pick][r][c] = maze[p[pick]][r][c]; // 원본
                else if (t == 1) tmpMaze[pick][r][c] = maze[p[pick]][Math.abs(c - 4)][r]; // 90도
                else if (t == 2) tmpMaze[pick][r][c] = maze[p[pick]][Math.abs(r - 4)][Math.abs(c - 4)]; // 180도
                else tmpMaze[pick][r][c] = maze[p[pick]][c][Math.abs(r - 4)]; // 270도
            }
        }
    }

    static void BFS(int r, int c) {
        queue.add(new Pos(r, c, 0, 0));
        visited[0][r][c] = true;

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int cr = p.curR; // 현재 행 좌표
            int cc = p.curC; // 현재 열 좌표
            int cz = p.curZ; // 현재 칸 좌표
            int dist = p.dist; // 현재 거리

            if (goalR == cr && goalC == cc && cz == 4) { // 목표 지점 도착
                min = Math.min(min, dist); // 최소 이동 거리 구하기
                queue.clear(); // 큐 비우기
                break;
            }

            for (int d = 0; d < 5; d++) {
                int nr = cr + dr[d]; // 다음 행 좌표
                int nc = cc + dc[d]; // 다음 열 좌표
                int uz = cz + 1; // 위칸
                int dz = cz - 1; // 아래칸

                // 다음 칸 탐색
                if (d == 0) {
                    if (uz < 5 && !visited[uz][nr][nc] && tmpMaze[uz][nr][nc]) { // 위칸으로 이동이 가능한 경우
                        visited[uz][nr][nc] = true; // 방문 처리
                        queue.add(new Pos(nr, nc, uz, dist + 1));
                    }
                    if (dz >= 0 && !visited[dz][nr][nc] && tmpMaze[dz][nr][nc]) { // 아래칸으로 이동이 가능한 경우
                        visited[dz][nr][nc] = true; // 방문 처리
                        queue.add(new Pos(nr, nc, dz, dist + 1));
                    }
                }
                // 현재 칸 탐색
                else {
                    if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visited[cz][nr][nc] || !tmpMaze[cz][nr][nc]) continue;
                    visited[cz][nr][nc] = true; // 방문 처리
                    queue.add(new Pos(nr, nc, cz, dist + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        queue = new LinkedList<>();
        maze = new boolean[5][5][5];
        tmpMaze = new boolean[5][5][5];
        pVisited = new boolean[5];
        p = new int[5];

        min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    if (Integer.parseInt(st.nextToken()) == 1) maze[i][j][k] = true;
                }
            }
        }

        perm(0);

        if (min == Integer.MAX_VALUE) System.out.println(-1); // 목표 지점까지 도달할 수 없는 경우
        else System.out.println(min);
    }
}