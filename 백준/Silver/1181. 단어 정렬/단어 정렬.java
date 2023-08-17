import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        // 중복 제거
        Set<String> uniqueSet = new HashSet<>(list);
        List<String> uniqueList = new ArrayList<>(uniqueSet);

        // 사전순으로 정렬
        Collections.sort(uniqueList);

        // 길이순으로 정렬
        uniqueList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for (String word : uniqueList) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}