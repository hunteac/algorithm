import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] map; // 지도
    public static int N; // 지도 크기
    public static int cnt = 0; // 단지별 아파트 수

    // DFS (깊이 우선 탐색) 메소드
    public static void DFS(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < N) { // 지도 범위 내에서만 확인
            if (!map[i][j]) return; // 집이 없으면 return
            cnt++;
            map[i][j] = false; // 방문 한 곳 지우기
            DFS(i - 1, j); // 상
            DFS(i, j + 1); // 우
            DFS(i + 1, j); // 하
            DFS(i, j - 1); // 좌 확인
        } else return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        int num = 0; // 단지 수
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '1') map[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) { // 집이 있는 곳 방문
                    DFS(i, j);
                    list.add(cnt);
                    num++;
                }
                cnt = 0;
            }
        }
        Collections.sort(list); // 오름차순 정렬
        System.out.println(num);
        for (int n : list) {
            System.out.println(n);
        }
    }
}