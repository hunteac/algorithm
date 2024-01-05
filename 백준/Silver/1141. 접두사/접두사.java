import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        int[] count = new int[26]; // 알파벳 별 부분집합 크기

        for (int i = 0; i < N; i++) words[i] = br.readLine();
        int max = 0; // 부분집합 최대 크기

        Arrays.sort(words); // 오름차순 정렬

        for (int i = N - 1; i >= 0; i--) {
            HashSet<String> set = new HashSet<>();
            Outer: for (int j = i - 1; j >= 0; j--) {
                if (words[i].charAt(0) != words[j].charAt(0) || set.contains(words[j]) || i == j) continue;

                for (String str : set) { // 이미 부분 집합이면 continue
                    if (str.length() > words[j].length()) {
                        if (words[j].equals(str.substring(0, words[j].length()))) continue Outer;
                    } else {
                        if (str.equals(words[j].substring(0, str.length()))) continue Outer;
                    }
                }

                // 접두어면 continue
                if (words[i].length() > words[j].length()) {
                    if (words[j].equals(words[i].substring(0, words[j].length()))) continue;
                } else {
                    if (words[i].equals(words[j].substring(0, words[i].length()))) continue;
                }

                set.add(words[j]); // 집합 포함
            }
            int curr = words[i].charAt(0) - 97;

            count[curr] = Math.max(count[curr], set.size() + 1);
//            System.out.print(words[i] + " ");
//            for (String str : set) {
//                System.out.print(str + " ");
//            }
//            System.out.println();
        }

        for (int i = 0; i < 26; i++) max += count[i];

        System.out.println(max);
    }
}