import java.util.*;

public class Main {
    static class Pos {
        int hr; // 머리 행 좌표
        int hc; // 머리 열 좌표
        int tr; // 꼬리 행 좌표
        int tc; // 꼬리 열 좌표
        Pos(int hr, int hc, int tr, int tc) {
            this.hr = hr;
            this.hc = hc;
            this.tr = tr;
            this.tc = tc;
        }
    }
    static Queue<Pos> queue; // BFS 큐
    static int[][] snake; // 뱀 위치
    static boolean[][] board; // 게임 보드
    static String[][] direction; // 방향 변환
    static int[][] moveD; // 뱀 진행 방향
    static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 순서
    static int[] dc = { 1, 0, -1, 0 };
    static int N; // 크기
    static int K; // 사과 개수
    static int L; // 방향 변환 정보
    static int time; // 종료 시간
    static int d; // 방향

    // 너비 우선 탐색
    static void BFS(int r, int c) {
        queue.add(new Pos(r, c, r, c));
        snake[r][c] = 1; // 시작 위치
        int len = 0; // 뱀 길이
        int t = 0; // 꼬리 위치

        while(!queue.isEmpty()) {
            time++;
            Pos p = queue.poll();

            boolean chk = false; // 방향 변환 결정
            int idx = 0;
            for (int i = 0; i < L; i++) {
                if (Integer.parseInt(direction[i][0]) == time - 1) {
                    chk = true;
                    idx = i;
                }
            }
            if (chk) { // 방향 변환
                if (direction[idx][1].equals("L")) d = (d + 3) % 4; // 왼쪽
                else d = (d + 1) % 4; // 오른쪽
            }

            moveD[len++][0] = d; // 진행 방향 기록

            int nr = p.hr + dr[d]; // 다음 머리 행 좌표
            int nc = p.hc + dc[d]; // 다음 머리 열 좌표

            // 벽에 부딪히거나 자기 자신을 만나면 종료
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || snake[nr][nc] == 1) {
                break;
            }

            if (board[nr][nc]) { // 다음 칸에 사과가 있는 경우
                board[nr][nc] = false; // 사과 먹기
                snake[nr][nc] = 1; // 머리 이동
                queue.add(new Pos(nr, nc, p.tr, p.tc));
            } else { // 사과가 없는 경우
                snake[nr][nc] = 1; // 머리 이동
                snake[p.tr][p.tc] = 0; // 꼬리 이동
                queue.add(new Pos(nr, nc, p.tr + dr[moveD[t][0]], p.tc + dc[moveD[t][0]]));
                t++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        moveD = new int[N * N][1];
        snake = new int[N][N];
        board = new boolean[N][N];

        queue = new LinkedList<>();

        K = sc.nextInt(); // 사과 개수

        // 사과 위치 입력
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1; // 행 좌표
            int c = sc.nextInt() - 1; // 열 좌표
            board[r][c] = true;
        }

        L = sc.nextInt();

        direction = new String[L][2];

        for (int i = 0; i < L; i++) {
            direction[i][0] = sc.next(); // 시간
            direction[i][1] = sc.next(); // 방향
        }

        BFS(0, 0); // 0, 0 시작

        System.out.println(time);
    }
}