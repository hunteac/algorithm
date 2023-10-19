import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            int[][] tower = new int[h][l]; // 주차 빌딩
            int[][] place = new int[h * l + 1][2]; // 자동차 위치
            
            int cnt = 0; // 손님 수
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) {
                    tower[i][j] = Integer.parseInt(st.nextToken());
                    if (tower[i][j] != -1) { 
                        place[tower[i][j]][0] = i;
                        place[tower[i][j]][1] = j;
                        cnt++;
                    }
                }
            }
            
            int time = 0; // 모든 손님이 차를 찾는 시간
            
            int[] ele = new int[h]; // 층별 컨베이어 위치
            
            for (int i = 1; i <= cnt; i++) {
                int r = place[i][0]; // 층 이동
                int c;
                if (ele[r] < place[i][1]) { // 컨베이어 이동
                    c = Math.min(l - place[i][1] + ele[r], Math.abs(ele[r] - place[i][1]));
                } else {
                    c = Math.min(place[i][1] + l - ele[r], Math.abs(ele[r] - place[i][1]));
                }
                
                time += r * 2 * 10 + c * 5; // 시간 추가
                
                ele[r] = place[i][1]; // 컨베이어 위치 이동
            }
            
            sb.append(time).append("\n");
        }
        System.out.println(sb);
    }
}