import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> boj = new ArrayList<>(); // 백준 학습 기록
        ArrayList<String> etc = new ArrayList<>(); // 그 외 학습 기록

        for (int i = 0; i < N; i++) {
            String record = br.readLine();
            if (record.length() > 6 && record.startsWith("boj.kr")) boj.add(record);
            else etc.add(record);
        }

        boj.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(o1.substring(7));
                int num2 = Integer.parseInt(o2.substring(7));
                return Integer.compare(num1, num2);
            }
        });

        etc.sort(new Comparator<String>() {
            @Override
            public int compare(String r1, String r2) {
                if (r1.length() != r2.length()) {
                    return Integer.compare(r1.length(), r2.length());
                } else {
                    for (int idx = 0; idx < r1.length(); idx++) {
                        if (r1.charAt(idx) != r2.charAt(idx)) {
                            return Character.compare(r1.charAt(idx), r2.charAt(idx));
                        }
                    }
                }
                return 0; // 두 문자열이 같은 경우
            }
        });

        for (String record : etc) sb.append(record).append("\n");
        for (String record : boj) sb.append(record).append("\n");

        System.out.println(sb);
    }
}