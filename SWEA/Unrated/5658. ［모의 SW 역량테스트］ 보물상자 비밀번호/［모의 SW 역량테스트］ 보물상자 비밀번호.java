import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            List<String> sPwds = new ArrayList<>(); // 문자열 비밀번호
            List<Integer> iPwds = new ArrayList<>(); // 정수 비밀번호
            int N = sc.nextInt();
            int K = sc.nextInt();
            String tBox = sc.next();
            int num = 0;
            int cnt = 0;
            for (int i = 0; i < N / 4; i++) { // 모든 비밀번호 구하기 N / 4번 회전
                for (int j = i; j < N + i; j++) {
                    if (j < N) sb.append(tBox.charAt(j));
                    else sb.append(tBox.charAt(j % N));
                    if (sb.length() == N / 4) {
                        if (!sPwds.contains(sb.toString())) sPwds.add(sb.toString()); // 중복 비밀번호 제거
                        sb.setLength(0); // sb 초기화
                    }
                }
            }
            for (int i = 0; i < sPwds.size(); i++) { // 16진법 -> 10진법 변환
                String s = sPwds.get(i);
                num = 0;
                cnt = 0;
                for (int j = s.length() - 1; j >= 0; j--) {
                    if (Character.isDigit(s.charAt(j))) {
                        num += (s.charAt(j) - '0') * (int) Math.pow(16, cnt);
                    } else {
                        num += (s.charAt(j) - 55) * (int) Math.pow(16, cnt);
                    }
                    cnt++;
                }
                iPwds.add(num);
            }
            Collections.sort(iPwds, (o1, o2) -> (o2 - o1)); // 내림차순 정렬
            System.out.println("#" + tc + " " + iPwds.get(K - 1)); // K번째로 큰 수 출력
        }
    }
}