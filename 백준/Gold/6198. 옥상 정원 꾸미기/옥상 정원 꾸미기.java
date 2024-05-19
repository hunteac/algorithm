import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] heigths = new int[N]; // 각 빌딩 높이

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            heigths[i] = h;
        }

        long sum = 0; // 빌딩의 수의 합

        int[][] building = new int[N][2]; // [][0]: 옥상을 볼 수 없는 다음 빌딩 번호, [][1]: 옥상이 보이는 빌딩 수
        building[N - 1][0] = N - 1; // 마지막 빌딩

        for (int i = N - 2; i >= 0; i--) {
            int currH = heigths[i]; // 현재 빌딩 높이

            int nextH = heigths[i + 1]; // 다음 빌딩 높이
            if (currH <= nextH) { // 바로 다음 빌딩의 옥상을 볼 수 없는 경우
                building[i][0] = i + 1;
                continue;
            }

            int nextIdx = i + 1; // 다음 빌딩 번호
            int tmp = 0; // 옥상을 볼 수 있는 빌딩 수

            while (true) {
                // 빌딩의 옥상을 못보거나 마지막 옥상인 경우
                if (currH <= nextH || nextIdx == N - 1) {
                    if (tmp < N - 1 - i && currH > nextH) tmp++; // 마지막 빌딩 옥상
                    building[i][0] = nextIdx;
                    building[i][1] = tmp;
                    break;
                }

                tmp += building[nextIdx][1] + 1;
                nextIdx = building[nextIdx][0];
                nextH = heigths[nextIdx];
            }

            sum += tmp;
        }

        System.out.println(sum);
    }
}
