import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        // 가로수 사이 거리 계산
        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = tree[i + 1] - tree[i];
        }
        // 거리를 오름차순으로 정렬
        Arrays.sort(distances);
        // 최대공약수 구하기
        int gcd = distances[0];
        for (int i = 1; i < n - 1; i++) {
            gcd = getGcd(gcd, distances[i]);
        }
        // 심을 가로수의 개수 계산
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            cnt += (distances[i] / gcd) - 1;
        }
        System.out.println(cnt);
    }
    // 두 수의 최대공약수를 구하는 메소드
    public static int getGcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return getGcd(b, a % b);
    }
}