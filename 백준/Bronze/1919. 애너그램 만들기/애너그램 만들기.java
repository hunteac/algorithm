import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] first = sc.next().split(""); // 첫번째 단어
        String[] second = sc.next().split(""); // 두번째 단어

        int[] cnt = new int[27]; // 첫번째 단어 문자 개수
        int[] count = new int[27]; // 두번째 단어 문자 개수

        for (int i = 0; i < first.length; i++) {
            cnt[first[i].charAt(0) - 97]++;
        }

        for (int i = 0; i < second.length; i++) {
            count[second[i].charAt(0) - 97]++;
        }

        int min = 0; // 제거할 문자 최소 개수

        for (int i = 0; i < 27; i++) {
            min += Math.abs(cnt[i] - count[i]); // 문자 제거
        }

        System.out.println(min);
    }
}