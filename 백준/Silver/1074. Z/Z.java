import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int currR = 0; // 현재 행
        int currC = 0; // 현재 열
        int num = 0; // 방문 횟수

        while (N >= 0) {
            if (r == currR && c == currC) break; // 도착

            // 전체 구역 4등분
            int middleR = (int) (currR + Math.pow(2, N - 1));
            int middleC = (int) (currC + Math.pow(2, N - 1));

            int div = (int) Math.pow((Math.pow(2, N - 1)), 2);

            if (r < middleR && c >= middleC) { // 두번째 구역
                num += div;
                currC += (int) Math.pow(2, N - 1);
            } else if (r >= middleR && c < middleC) { // 세번째 구역
                num += div * 2;
                currR += (int) Math.pow(2, N - 1);
            } else if (r >= middleR) { // 네번째 구역
                num += div * 3;
                currR += (int) Math.pow(2, N - 1);
                currC += (int) Math.pow(2, N - 1);
            }

            N--;
        }

        System.out.println(num);
    }
}