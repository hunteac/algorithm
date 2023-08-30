import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashSet<String> record = new HashSet<>(); // 춤을 추는 사람을 담는 셋
        record.add("ChongChong"); // 맨 처음 춤을 추는 총총
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if (!record.contains(A) && !record.contains(B)) continue; // 아무도 춤을 안추면 continue
            if (record.contains(A) && record.contains(B)) continue; // 모두 춤을 춰도 continue
            if (record.contains(A)) record.add(B); // 춤을 추는 사람을 만나면 기록에 추가
            else if (record.contains(B)) record.add(A); // 위와 동일
            cnt++;
        }
        System.out.println(cnt);
    }
}