import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char[][] map;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '_') continue;

                if (isHeart(i, j)) {
                    int leftArm = getLen(i, j - 1, 3);
                    int rightArm = getLen(i, j + 1, 1);
                    int waist = getLen(i + 1, j, 2);
                    int leftLeg = getLen(i + waist + 1, j - 1, 2);
                    int rightLeg = getLen(i + waist + 1, j + 1, 2);

                    sb.append(i + 1).append(" ").append(j + 1).append("\n");
                    sb.append(leftArm).append(" ").append(rightArm).append(" ");
                    sb.append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);

                    System.out.println(sb);
                    return;
                }
            }
        }

    }

    public static boolean isHeart(int x, int y) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '_') continue;

            cnt++;
        }

        return cnt == 4;
    }

    public static int getLen(int x, int y, int d) {
        int len = 0;

        while (x >= 0 && x < N && y >= 0 && y < N && map[x][y] == '*') {
            len++;
            x += dx[d];
            y += dy[d];
        }

        return len;
    }
}