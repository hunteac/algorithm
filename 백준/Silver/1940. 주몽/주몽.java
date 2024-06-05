import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 재료 총 개수
        int M = Integer.parseInt(br.readLine()); // 목표 갑옷 번호

        if (M >= 200000) { // 만들 수 없는 수
            System.out.println(0);
            return;
        }

        HashSet<Integer> chk = new HashSet<>(); // 재료 사용 여부
        int[] materials = new int[N]; // 재료 번호
        int cnt = 0; // 만들 수 있는 갑옷 개수

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (chk.contains(M - n)) {
                chk.remove(n);
                cnt++;
            } else {
                chk.add(n);
            }
        }

        System.out.println(cnt);
    }
}
