import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            List<Integer> Pwd = new ArrayList<>(); // 비밀번호
            int N = sc.nextInt();
            int K = sc.nextInt();
            String tBox = sc.next();
            int num = 0;
            for (int i = 0; i < N / 4; i++) { // 모든 비밀번호 구하기 -> N / 4번 회전
                for (int j = i; j < N + i; j++) {
                    if (j < N) sb.append(tBox.charAt(j));
                    else sb.append(tBox.charAt(j % N));
                    if (sb.length() == N / 4) {
                        num = 0;
                        for (int k = sb.length() - 1; k >= 0; k--) {
                            if (Character.isDigit(sb.charAt(k))) {
                                num += (sb.charAt(k) - '0') * (int) Math.pow(16, sb.length() - k - 1);
                            } else {
                                num += (sb.charAt(k) - 55) * (int) Math.pow(16, sb.length() - k - 1);
                            }
                        }
                        sb.setLength(0); // sb 초기화
                        if (!Pwd.contains(num)) Pwd.add(num);
                    }
                }
            }
            Collections.sort(Pwd, (o1, o2) -> (o2 - o1)); // 내림차순 정렬
            System.out.println("#" + tc + " " + Pwd.get(K - 1)); // K번째로 큰 수 출력
        }
    }
}