import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static String[] sArr;
    public static void recursion(int l, int r, int len) {
        if (len == 0) return;
        int n = (l + r) / 2; // 중앙
        int s = len / 2; // 공백으로 만들 범위
        for (int i = n - s; i <= n + s; i++) {
            sArr[i] = " ";
        }
        recursion(l, n - s - 1, len / 3); // 왼쪽
        recursion(n + s + 1, r, len / 3); // 오른쪽
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int len = (int) Math.pow(3, N);
            sArr = new String[len];
            for (int i = 0; i < len; i++) {
                sArr[i] = "-";
            }
            recursion(0, sArr.length - 1, len / 3);
            System.out.println(Arrays.stream(sArr).collect(Collectors.joining()));
        }
    }
}