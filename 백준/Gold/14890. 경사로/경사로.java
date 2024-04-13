import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[2][N][N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            boolean colChk = true;
            boolean rowChk = true;
            for (int j = 1; j < N; j++) {
                int colLen = Math.abs(map[i][j - 1] - map[i][j]); // 높이 차이
                int rowLen = Math.abs(map[j - 1][i] - map[j][i]);
                int start = j; // 시작 위치

                if (colLen > 1) colChk = false; // 높이 차이 > 1 이면 불가능
                if (rowLen > 1) rowChk = false;
                if (!colChk && !rowChk) break; // 행, 열 모두 불가능

                if (colChk && !visited[0][i][j] && colLen == 1) { // 열 확인
                    if (map[i][j - 1] > map[i][j]) { // 하강
                        if (start + L > N) colChk = false; // 범위 벗어남
                        else {
                            for (int idx = start; idx < start + L; idx++) {
                                if (idx < start + L - 1 && map[i][idx] == map[i][idx + 1]) visited[0][i][idx] = true;
                                else if (idx == start + L - 1) visited[0][i][idx] = true;
                                else { // 경사로를 놓을 수 없음
                                    colChk = false;
                                    break;
                                }
                            }
                        }
                    } else { // 상승
                        if (start - L < 0) colChk = false; // 범위 벗어남
                        else {
                            for (int idx = start - L; idx < start; idx++) {
                                if (!visited[0][i][idx] && idx < start - 1 && map[i][idx] == map[i][idx + 1]) visited[0][i][idx] = true;
                                else if (!visited[0][i][idx] && idx == start - 1) visited[0][i][idx] = true;
                                else { // 경사로를 놓을 수 없음
                                    colChk = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (rowChk && !visited[1][j][i] && rowLen == 1) { // 행 확인
                    if (map[j - 1][i] > map[j][i]) { // 하강
                        if (start + L > N) rowChk = false; // 범위 벗어남
                        else {
                            for (int idx = start; idx < start + L; idx++) {
                                if (idx < start + L - 1 && map[idx][i] == map[idx + 1][i]) visited[1][idx][i] = true;
                                else if (idx == start + L - 1) visited[1][idx][i] = true;
                                else { // 경사로를 놓을 수 없음
                                    rowChk = false;
                                    break;
                                }
                            }
                        }
                    } else { // 상승
                        if (start - L < 0) rowChk = false; // 범위 벗어남
                        else {
                            for (int idx = start - L; idx < start; idx++) {
                                if (!visited[1][idx][i] && idx < start - 1 && map[idx][i] == map[idx + 1][i]) visited[1][idx][i] = true;
                                else if (!visited[1][idx][i] && idx == start - 1) visited[1][idx][i] = true;
                                else { // 경사로를 놓을 수 없음
                                    rowChk = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (colChk) cnt++; // 열 가능
            if (rowChk) cnt++; // 행 가능
        }

        System.out.println(cnt);
    }
}