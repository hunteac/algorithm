import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt(); // 높이
            int W = sc.nextInt(); // 너비
            char[][] map = new char[H][W]; // 맵
            for (int i = 0; i < H; i++) {
                String s = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j); // 맵 형성
                }
            }
            int N = sc.nextInt(); // 명령 수
            int cnt = 1;
            String C = sc.next(); // 명령 입력
            for (int i = 0; i < N; i++) {
                char c = C.charAt(i);
                Out: for (int j = 0; j < H; j++) {
                    for (int k = 0; k < W; k++) {
                        if (map[j][k] == '^' || map[j][k] == 'v' || map[j][k] == '<' || map[j][k] == '>') {
                            if (c == 'U') {
                                map[j][k] = '^'; // 방향 바꾸기
                                if (j - 1 >= 0 && map[j - 1][k] == '.') { // 바라보는 방향이 땅이라면
                                    map[j][k] = '.'; // 기존에 있던 자리 땅으로 바꾸기
                                    map[j - 1][k] = '^'; // 이동
                                }
                            } else if (c == 'D') {
                                map[j][k] = 'v'; // 방향 바꾸기
                                if (j + 1 < H && map[j + 1][k] == '.') { // 바라보는 방향이 땅이라면
                                    map[j][k] = '.'; // 기존에 있던 자리 땅으로 바꾸기
                                    map[j + 1][k] = 'v'; // 이동
                                }
                            } else if (c == 'L') {
                                map[j][k] = '<'; // 방향 바꾸기
                                if (k - 1 >= 0 && map[j][k - 1] == '.') { // 바라보는 방향이 땅이라면
                                    map[j][k] = '.'; // 기존에 있던 자리 땅으로 바꾸기
                                    map[j][k - 1] = '<'; // 이동
                                }
                            } else if (c == 'R') {
                                map[j][k] = '>'; // 방향 바꾸기
                                if (k + 1 < W && map[j][k + 1] == '.') { // 바라보는 방향이 땅이라면
                                    map[j][k] = '.'; // 기존에 있던 자리 땅으로 바꾸기
                                    map[j][k + 1] = '>'; // 이동
                                }
                            } else if (c == 'S') {
                                if (map[j][k] == '^') {
                                    cnt = 1;
                                    while (j - cnt >= 0) {
                                        if (map[j - cnt][k] == '*') {
                                            map[j - cnt][k] = '.'; // 벽돌벽 부수기
                                            break Out;
                                        } else if (map[j - cnt][k] == '#')
                                            break Out; // 강철벽은 아무일도 안일어남
                                        cnt++;
                                    }
                                } else if (map[j][k] == 'v') {
                                    cnt = 1;
                                    while (j + cnt < H) {
                                        if (map[j + cnt][k] == '*') {
                                            map[j + cnt][k] = '.'; // 벽돌벽 부수기
                                            break Out;
                                        } else if (map[j + cnt][k] == '#')
                                            break Out; // 강철벽은 아무일도 안일어남
                                        cnt++;
                                    }
                                } else if (map[j][k] == '<') {
                                    cnt = 1;
                                    while (k - cnt >= 0) {
                                        if (map[j][k - cnt] == '*') {
                                            map[j][k - cnt] = '.'; // 벽돌벽 부수기
                                            break Out;
                                        } else if (map[j][k - cnt] == '#')
                                            break Out; // 강철벽은 아무일도 안일어남
                                        cnt++;
                                    }
                                } else if (map[j][k] == '>') {
                                    cnt = 1;
                                    while (k + cnt < W) {
                                        if (map[j][k + cnt] == '*') {
                                            map[j][k + cnt] = '.'; // 벽돌벽 부수기
                                            break Out;
                                        } else if (map[j][k + cnt] == '#')
                                            break Out; // 강철벽은 아무일도 안일어남
                                        cnt++;
                                    }
                                }
                            }
                            break Out;
                        }
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}