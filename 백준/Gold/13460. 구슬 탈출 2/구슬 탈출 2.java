import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r;
        int c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int time = 0; // 빨간 구슬이 탈출하는데 걸리는 시간

        char[][] board = new char[N][M]; // 보드

        Queue<Pos> red = new LinkedList<>();
        Queue<Pos> blue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M]; // 방문 체크

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    red.add(new Pos(i, j)); // 빨간 구슬 위치 담기
                    board[i][j] = '.';
                }
                else if (board[i][j] == 'B') {
                    blue.add(new Pos(i, j)); // 파란 구슬 위치 담기
                    board[i][j] = '.';
                }
            }
        }

        int[] dr = { -1, 0, 1, 0 }; // 행 탐색
        int[] dc = { 0, 1, 0, -1 }; // 열 탐색
        boolean chk = false; // 가능 여부

        Outer: while (!red.isEmpty() && !blue.isEmpty()) {
            time++; // 시간 +1
            int len = red.size();

            if (time > 10) break; // 제한 시간을 넘기면 종료

            for (int i = 0; i < len; i++) {
                Pos rp = red.poll(); // 빨간 구슬 위치
                Pos bp = blue.poll(); // 파란 구슬 위치

                visited[rp.r][rp.c][bp.r][bp.c] = true; // 방문 처리

                for (int d = 0; d < 4; d++) {
                    boolean rChk = false; // 빨간 구슬 꺼내기 체크
                    boolean bChk = false; // 파란 구슬 꺼내기 체크
                    boolean chk1 = false; // 빨간 구슬 이동 완료 체크
                    boolean chk2 = false; // 파란 구슬 이동 완료 체크

                    int nrr = rp.r;
                    int nrc = rp.c;
                    int nbr = bp.r;
                    int nbc = bp.c;

                    while (true) {
                        int tmpNrr = nrr + dr[d];
                        int tmpNrc = nrc + dc[d];
                        int tmpNbr = nbr + dr[d];
                        int tmpNbc = nbc + dc[d];

                        // 범위 내에서만 이동 가능
                        if (tmpNrr >= 0 && tmpNrr < N && tmpNrc >= 0 && tmpNrc < M && tmpNbr >= 0 && tmpNbr < N && tmpNbc >= 0 && tmpNbc < M) {
                            // 빨간 구슬 이동
                            if (tmpNrr > 0 && tmpNrr < N - 1 && tmpNrc > 0 && tmpNrc < M - 1 && !rChk) {
                                if (board[tmpNbr][tmpNbc] == '#' && tmpNrr == nbr && tmpNrc == nbc && !bChk) { // 두 구슬이 겹치는 경우
                                    chk1 = true;
                                } else if (board[tmpNrr][tmpNrc] == '.' || board[tmpNrr][tmpNrc] == 'O') {
                                    nrr += dr[d];
                                    nrc += dc[d];
                                } else {
                                    chk1 = true; // 이동 완료
                                }
                            } else {
                                chk1 = true; // 이동 완료
                            }

                            // 파란 구슬 이동
                            if (tmpNbr > 0 && tmpNbr < N - 1 && tmpNbc > 0 && tmpNbc < M - 1 && !bChk) { 
                                if (board[tmpNrr][tmpNrc] == '#' && tmpNbr == nrr && tmpNbc == nrc && !rChk) { // 두 구슬이 겹치는 경우
                                    chk2 = true;
                                } else if (board[tmpNbr][tmpNbc] == '.' || board[tmpNbr][tmpNbc] == 'O') {
                                    nbr += dr[d];
                                    nbc += dc[d];
                                } else {
                                    chk2 = true; // 이동 완료
                                }
                            } else {
                                chk2 = true; // 이동 완료
                            }
                        }

                        if (board[nrr][nrc] == 'O') rChk = true; // 빨간 구슬 꺼내기
                        if (board[nbr][nbc] == 'O') bChk = true; // 파란 구슬 꺼내기
                        if (chk1 && chk2 || rChk && bChk) break; // 이동이 끝나면 종료
                    }
//                    System.out.println("rR : " + nrr + " rC : " + nrc);
//                    System.out.println("bR : " + nbr + " bC : " + nbc);

                    if (visited[nrr][nrc][nbr][nbc]) continue; // 이미 방문한 곳은 continue

                    if (rChk && !bChk) { // 빨간 구슬만 구멍에 들어간 경우
                        chk = true; // 성공
                        break Outer; // 종료
                    } else if (!rChk && bChk) continue; // 파란 구슬만 구멍에 들어간 경우
                    else if (rChk && bChk) continue; // 모두 들어간 경우

                    red.add(new Pos(nrr, nrc)); // 빨간 구슬 다음 위치 담기
                    blue.add(new Pos(nbr, nbc)); // 파란 구슬 다음 위치 담기
                }
            }
        }

        if (chk && time <= 10) System.out.println(time);
        else System.out.println(-1);
    }
}