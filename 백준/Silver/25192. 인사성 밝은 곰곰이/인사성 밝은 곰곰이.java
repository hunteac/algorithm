import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> record = new HashSet<>(); // 채팅 기록 담기용 덱
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                record.clear(); // 새로운 사람이 들어온 이후 처음 채팅은 반드시 곰곰티콘
                continue;
            }
            if (record.contains(chat)) continue; // 채팅을 친적이 있다면 continue
            record.add(chat); // 채팅 기록에 담기
            cnt++; // ENTER 이후 채팅을 친적이 없다면 cnt 1 증가
        }
        System.out.println(cnt);
    }
}